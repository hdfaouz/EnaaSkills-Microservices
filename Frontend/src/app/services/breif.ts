import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface BreifDto {
  idBreif?: number;
  titre: string;
  dateDepart: Date;
  dateFin: Date;
  rendus?: number[];
  competences: CompetenceDto[];
}

export interface CompetenceDto {
  idCompetence: number;
  name: string;
  description: string;
  validated: boolean;
}

@Injectable({
  providedIn: 'root'
})
export class BreifService {
  private apiUrl = 'http://localhost:8080/breif';

  constructor(private http: HttpClient) { }

  getRendusByBreifId(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/${id}/idsrendu`);
  }

  addBreif(breif: BreifDto): Observable<BreifDto> {
    return this.http.post<BreifDto>(`${this.apiUrl}/add`, breif);
  }

  getAllBreifs(): Observable<BreifDto[]> {
    return this.http.get<BreifDto[]>(`${this.apiUrl}/all`);
  }

  updateBreif(id: number, breif: BreifDto): Observable<BreifDto> {
    return this.http.put<BreifDto>(`${this.apiUrl}/update/${id}`, breif);
  }

  deleteBreif(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`);
  }

  getBreifById(id: number): Observable<BreifDto> {
    return this.http.get<BreifDto>(`${this.apiUrl}/getById/${id}`);
  }

  getAllCompetences(): Observable<CompetenceDto[]> {
    return this.http.get<CompetenceDto[]>(`${this.apiUrl}/competence`);
  }
}
