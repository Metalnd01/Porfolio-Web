import { Component, OnInit } from '@angular/core';
import { graficos } from 'src/app/model/graficos.model';
import { GraficosService } from 'src/app/servicios/graficos.service';

@Component({
  selector: 'app-graficos',
  templateUrl: './graficos.component.html',
  styleUrls: ['./graficos.component.css']
})
export class GraficosComponent implements OnInit {

  graficos: graficos = new graficos("", 0);

  constructor(public graficosService: GraficosService) { }

  ngOnInit(): void {
    this.graficosService.getGraficos().subscribe(data => this.graficos = data);
  }

}
