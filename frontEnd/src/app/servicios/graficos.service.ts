import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { graficos } from '../model/graficos.model';

@Injectable({
  providedIn: 'root'
})
export class GraficosService {

  private apiServerUrl = 'https://backend-portfolio-wkm.fly.dev';
  
  constructor(private http: HttpClient) { }

  public getGraficos(): Observable<graficos[]> {
    return this.http.get<graficos[]>(`${this.apiServerUrl}/graficos/all`);
  }

  public addGraficos(graficos: graficos): Observable<graficos>{
    return this.http.post<graficos>(`${this.apiServerUrl}/graficos/add`, graficos);
  }

  public updateGraficos(graficos: graficos): Observable<graficos>{
    return this.http.put<graficos>(`${this.apiServerUrl}/graficos/update`, graficos);
  }

  public deleteGraficos(IdSkill: number): Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/graficos/delete/${IdSkill}`);
  }
}
