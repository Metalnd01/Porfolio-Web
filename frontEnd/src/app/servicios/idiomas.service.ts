import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { idiomas } from '../model/idiomas.model';

@Injectable({
  providedIn: 'root'
})
export class IdiomasService {

  URL = 'http://localhost:8080/idiomas/';

  constructor(private http: HttpClient) { }

  public getIdiomas():Observable<idiomas>{
    return this.http.get<idiomas>(this.URL+ 'traer');
  }
}
