import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { experiencia } from '../model/experiencia.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ExperienciaService {

  private apiServerUrl = "https://porfolio-web-2a8dc.web.app";

  constructor(private http: HttpClient) { }

  public getExperiencia(): Observable<experiencia[]> {
    return this.http.get<experiencia[]>(`${this.apiServerUrl}/experiencia/all`);
  }

  public addExperiencia(experiencia: experiencia): Observable<experiencia>{
    return this.http.post<experiencia>(`${this.apiServerUrl}/experiencia/add`, experiencia);
  }

  public updateExperiencia(experiencia: experiencia): Observable<experiencia>{
    return this.http.put<experiencia>(`${this.apiServerUrl}/experiencia/update`, experiencia);
  }

  public deleteExperiencia(IdExp: number): Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/experiencia/delete/${IdExp}`);
  }
}
