import { Injectable } from '@angular/core';
import { acercaDe } from '../model/acercaDe.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AcercaDeService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getAcercaDe(): Observable<acercaDe[]> {
    return this.http.get<acercaDe[]>(`${this.apiServerUrl}/acercaDe/all`);
  }

  public addAcercaDe(acercaDe: acercaDe): Observable<acercaDe>{
    return this.http.post<acercaDe>(`${this.apiServerUrl}/acercaDe/add`, acercaDe);
  }

  public updateAcercaDe(acercaDe: acercaDe): Observable<acercaDe>{
    return this.http.put<acercaDe>(`${this.apiServerUrl}/acercaDe/update`, acercaDe);
  }

  public deleteAcercaDe(IdAcerca: number): Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/acercaDe/delete/${IdAcerca}`);
  }
}
