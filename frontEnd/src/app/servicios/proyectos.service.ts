import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { proyectos } from '../model/proyectos.model';

@Injectable({
  providedIn: 'root'
})
export class ProyectosService {

  URL = 'http://localhost:8080/proyectos/'

  constructor(private http: HttpClient) { }

  public getProyectos():Observable<proyectos>{
    return this.http.get<proyectos>(this.URL+ 'traer');
  }
}
