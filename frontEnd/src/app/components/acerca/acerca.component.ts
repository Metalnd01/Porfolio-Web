import { Component, OnInit } from '@angular/core';
import { acercaDe } from 'src/app/model/acercaDe.model';
import { AcercaDeService } from 'src/app/servicios/acerca-de.service';


@Component({
  selector: 'app-acerca',
  templateUrl: './acerca.component.html',
  styleUrls: ['./acerca.component.css']
})
export class AcercaComponent implements OnInit {

  acercaDe: acercaDe = new acercaDe("");
  constructor( public acercaDeService: AcercaDeService) { }

  ngOnInit(): void {
    this.acercaDeService.getAcercaDe().subscribe(data => {this.acercaDe = data})
  }

}
