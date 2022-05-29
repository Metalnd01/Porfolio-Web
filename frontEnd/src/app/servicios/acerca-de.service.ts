import { Injectable } from '@angular/core';
import { acercaDe } from '../model/acercaDe.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AcercaDeService {

  URL = 'http://localhost:8080/acercade/';

  constructor(private http: HttpClient) { }

  public getAcercaDe(): Observable<acercaDe>{
    return this.http.get<acercaDe>(this.URL+ 'traer');
  }
}
