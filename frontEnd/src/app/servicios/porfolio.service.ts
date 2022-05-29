import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PorfolioService {

  url:string = 'http:localhost:8080/porfolio/';
  constructor(private http:HttpClient) { }

  obtenerDatos ():Observable<any> {
    return this.http.get(this.url + 'persona');
  }
}
