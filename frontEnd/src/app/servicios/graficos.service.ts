import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { graficos } from '../model/graficos.model';

@Injectable({
  providedIn: 'root'
})
export class GraficosService {

  URL = 'http://localhost:8080/graficos/'

  constructor(private http: HttpClient) { }

  public getGraficos(): Observable<graficos>{
    return this.http.get<graficos>(this.URL+ 'traer');
  }
}
