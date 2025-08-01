// brief-form.component.ts
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule, FormBuilder, FormGroup, FormArray, Validators } from '@angular/forms';
import { BreifService, BreifDto, CompetenceDto } from '../../services/breif';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-brief-form',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  templateUrl: './brief-form.html',
  styleUrls: ['./brief-form.css']
})
export class BriefFormComponent {
  @Input() currentBrief?: BreifDto;
  @Output() saved = new EventEmitter<void>();

  briefForm: FormGroup;
  competences: CompetenceDto[] = [];
  isLoading = false;

  constructor(
    private fb: FormBuilder,
    private briefService: BreifService,
    public activeModal: NgbActiveModal
  ) {
    this.briefForm = this.fb.group({
      titre: ['', Validators.required],
      dateDepart: ['', Validators.required],
      dateFin: ['', Validators.required],
      selectedCompetences: this.fb.array([])
    });

    this.loadCompetences();
  }

  ngOnInit(): void {
    if (this.currentBrief) {
      this.patchFormValues();
    }
  }

  loadCompetences(): void {
    this.briefService.getAllCompetences().subscribe({
      next: (data) => this.competences = data,
      error: (err) => console.error('Error loading competences', err)
    });
  }

  patchFormValues(): void {
    if (!this.currentBrief) return;

    this.briefForm.patchValue({
      titre: this.currentBrief.titre,
      dateDepart: this.formatDate(this.currentBrief.dateDepart),
      dateFin: this.formatDate(this.currentBrief.dateFin)
    });

    this.currentBrief.competences?.forEach(comp => {
      this.selectedCompetences.push(this.fb.control(comp.idCompetence));
    });
  }

  formatDate(date: any): string {
    return new Date(date).toISOString().split('T')[0];
  }

  get selectedCompetences(): FormArray {
    return this.briefForm.get('selectedCompetences') as FormArray;
  }

  onCompetenceToggle(event: Event, competenceId: number): void {
    const isChecked = (event.target as HTMLInputElement).checked;

    if (isChecked) {
      this.selectedCompetences.push(this.fb.control(competenceId));
    } else {
      const index = this.selectedCompetences.controls
        .findIndex(c => c.value === competenceId);
      if (index >= 0) {
        this.selectedCompetences.removeAt(index);
      }
    }
  }

  isCompetenceSelected(competenceId: number): boolean {
    return this.selectedCompetences.controls
      .some(c => c.value === competenceId);
  }

  onSubmit(): void {
    if (this.briefForm.invalid) return;

    this.isLoading = true;
    const briefData: BreifDto = {
      ...this.briefForm.value,
      competences: this.selectedCompetences.value.map((id: number) => ({ id }))
    };

    const operation = this.currentBrief
      ? this.briefService.updateBreif(this.currentBrief.idBreif!, briefData)
      : this.briefService.addBreif(briefData);

    operation.subscribe({
      next: () => {
        this.activeModal.close();
        this.saved.emit();
      },
      error: (err) => {
        console.error('Error saving brief', err);
        this.isLoading = false;
      }
    });
  }
}
