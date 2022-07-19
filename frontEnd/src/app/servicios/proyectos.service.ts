import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { proyectos } from '../model/proyectos.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProyectosService {

  private apiServerUrl = "https://porfolio-web-backend.herokuapp.com";

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
