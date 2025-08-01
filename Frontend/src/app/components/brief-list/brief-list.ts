// brief-list.component.ts
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { BreifService, BreifDto } from '../../services/breif';
import { BriefFormComponent } from '../brief-form/brief-form';

@Component({
  selector: 'app-brief-list',
  standalone: true,
  imports: [
    CommonModule,
    RouterModule,
    BriefFormComponent
  ],
  templateUrl: './brief-list.html',
  styleUrls: ['./brief-list.css']
})
export class BriefListComponent implements OnInit {
  briefs: BreifDto[] = [];

  constructor(
    private briefService: BreifService,
    private modalService: NgbModal
  ) {}

  ngOnInit(): void {
    this.loadBriefs();
  }

  loadBriefs(): void {
    this.briefService.getAllBreifs().subscribe(
      data => this.briefs = data,
      error => console.error('Error loading briefs', error)
    );
  }

  openBriefModal(brief?: BreifDto): void {
    const modalRef = this.modalService.open(BriefFormComponent, { size: 'lg' });
    modalRef.componentInstance.currentBrief = brief;

    modalRef.closed.subscribe({
      next: () => this.loadBriefs()
    });
  }

  deleteBrief(id: number): void {
    if (confirm('Are you sure you want to delete this brief?')) {
      this.briefService.deleteBreif(id).subscribe({
        next: () => this.loadBriefs(),
        error: (err) => console.error('Error deleting brief', err)
      });
    }
  }
}
