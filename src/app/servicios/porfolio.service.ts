import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PorfolioService {

  url:string = 'http:npinti.ddns.net:9008/api/';
  constructor(private http:HttpClient) { }

  obtenerDatos ():Observable<any> {
    return this.http.get(this.url + 'persona');
  }
}
