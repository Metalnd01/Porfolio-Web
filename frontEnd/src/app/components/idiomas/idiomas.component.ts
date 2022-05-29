import { Component, OnInit } from '@angular/core';
import { idiomas } from 'src/app/model/idiomas.model';
import { IdiomasService } from 'src/app/servicios/idiomas.service';

@Component({
  selector: 'app-idiomas',
  templateUrl: './idiomas.component.html',
  styleUrls: ['./idiomas.component.css']
})
export class IdiomasComponent implements OnInit {

  idiomas: idiomas = new idiomas("", "", "", "");

  constructor(public idiomasService: IdiomasService) { }

  ngOnInit(): void {
    this.idiomasService.getIdiomas().subscribe(data => this.idiomas = data);
  }

}
