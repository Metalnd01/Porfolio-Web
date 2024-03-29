import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { proyectos } from '../model/proyectos.model';

@Injectable({
  providedIn: 'root'
})
export class ProyectosService {

  private apiServerUrl = "https://backend-portfolio-wkm.fly.dev";

  constructor(private http: HttpClient) { }

  public getProyectos(): Observable<proyectos[]> {
    return this.http.get<proyectos[]>(`${this.apiServerUrl}/proyectos/all`);
  }

  public addProyectos(proyectos: proyectos): Observable<proyectos>{
    return this.http.post<proyectos>(`${this.apiServerUrl}/proyectos/add`, proyectos);
  }

  public updateProyectos(proyectos: proyectos): Observable<proyectos>{
    return this.http.put<proyectos>(`${this.apiServerUrl}/proyectos/update`, proyectos);
  }

  public deleteProyectos(IdProy: number): Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/proyectos/delete/${IdProy}`);
  }
}
