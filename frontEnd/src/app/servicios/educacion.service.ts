import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { educacion } from '../model/educacion.model';

@Injectable({
  providedIn: 'root'
})
export class EducacionService {

  private apiServerUrl = "https://porfolio-web-backend.herokuapp.com";

  constructor(private http: HttpClient) { }

  public getEducacion(): Observable<educacion[]> {
    return this.http.get<educacion[]>(`${this.apiServerUrl}/educacion/all`);
  }

  public addEducacion(educacion: educacion): Observable<educacion> {
    return this.http.post<educacion>(`${this.apiServerUrl}/educacion/add`, educacion);
  }

  public updateEducacion(educacion: educacion): Observable<educacion> {
    return this.http.put<educacion>(`${this.apiServerUrl}/educacion/update`, educacion);
  }

  public deleteEducacion(IdEdu: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/educacion/delete/${IdEdu}`);
  }
}
