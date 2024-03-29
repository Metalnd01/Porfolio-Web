import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { idiomas } from '../model/idiomas.model';

@Injectable({
  providedIn: 'root'
})
export class IdiomasService {

  private apiServerUrl = "https://backend-portfolio-wkm.fly.dev";

  constructor(private http: HttpClient) { }

  public getIdiomas(): Observable<idiomas[]> {
    return this.http.get<idiomas[]>(`${this.apiServerUrl}/idiomas/all`);
  }

  public addIdiomas(idiomas: idiomas): Observable<idiomas>{
    return this.http.post<idiomas>(`${this.apiServerUrl}/idiomas/add`, idiomas);
  }

  public updateIdiomas(idiomas: idiomas): Observable<idiomas>{
    return this.http.put<idiomas>(`${this.apiServerUrl}/idiomas/update`, idiomas);
  }

  public deleteIdiomas(idIdioma: number): Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/idiomas/delete/${idIdioma}`);
  }
}
