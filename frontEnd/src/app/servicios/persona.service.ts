import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { persona } from '../model/persona.model';


@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  private apiServerUrl = "https://backend-portfolio-wkm.fly.dev";
 
  constructor(private http: HttpClient) { }

  public getPersona(): Observable<persona>{
    return this.http.get<persona>(`${this.apiServerUrl}/persona/id/1`);
  }

  public updatePersona(persona: persona): Observable<persona>{
    return this.http.put<persona>(`${this.apiServerUrl}/persona/update`, persona);
  }
}
