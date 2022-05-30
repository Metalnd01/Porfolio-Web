import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { idiomas } from 'src/app/model/idiomas.model';
import { IdiomasService } from 'src/app/servicios/idiomas.service';

@Component({
  selector: 'app-idiomas',
  templateUrl: './idiomas.component.html',
  styleUrls: ['./idiomas.component.css']
})
export class IdiomasComponent implements OnInit {


  public idiomas:idiomas[] = [];
  public editIdiomas:idiomas | undefined;
  public deleteIdiomas:idiomas | undefined;

  constructor(private idiomasService: IdiomasService){}

  ngOnInit(): void {
    this.getIdiomas();
  }

  public getIdiomas():void{
    this.idiomasService.getIdiomas().subscribe({
      next:(Response: idiomas[]) =>{
        this.idiomas=Response;
      },
      error:(error:HttpErrorResponse) => {
        alert(error.message);
      }
    })
  }
  

  public onOpenModal(mode:String, idiomas?: idiomas):void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if(mode==='add'){
      button.setAttribute('data-target', '#addIdiomasModal');
    } else if (mode==='delete') {
      this.deleteIdiomas = idiomas;
      button.setAttribute('data-target', '#deleteIdiomasModal');
    } else if (mode==='edit') {
      this.editIdiomas = idiomas;
      button.setAttribute('data-target', '#editIdiomasModal');
    }

    container?.appendChild(button);
    button.click();
  }
  
  public onAddIdiomas(addForm: NgForm){
    document.getElementById('add-idiomas-form')?.click();
    this.idiomasService.addIdiomas(addForm.value).subscribe({
        next: (response:idiomas) => {
          console.log(response);
          this.getIdiomas();
          addForm.reset();
        },
        error:(error:HttpErrorResponse) => {
          alert(error.message);
          addForm.reset();
        }
      }
    )
  }

  public onUpdateIdiomas(idiomas: idiomas){
    this.editIdiomas=idiomas;
    document.getElementById('add-idiomas-form')?.click();
    this.idiomasService.updateIdiomas(idiomas).subscribe({
        next: (response:idiomas) => {
          console.log(response);
          this.getIdiomas();
        },
        error:(error:HttpErrorResponse) => {
          alert(error.message);
        }
      }
    )
  }

  public onDeleteIdiomas(idIdioma: number):void{
    this.idiomasService.deleteIdiomas(idIdioma).subscribe({
        next: (response:void) => {
          console.log(response);
          this.getIdiomas();
        },
        error:(error:HttpErrorResponse) => {
          alert(error.message);
        }
      }
    )
  }

}
