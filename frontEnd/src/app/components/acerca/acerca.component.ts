import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { acercaDe } from 'src/app/model/acercaDe.model';
import { AcercaDeService } from 'src/app/servicios/acerca-de.service';


@Component({
  selector: 'app-acerca',
  templateUrl: './acerca.component.html',
  styleUrls: ['./acerca.component.css']
})
export class AcercaComponent implements OnInit {


  public acercaDe:acercaDe[] = [];
  public editAcercaDe:acercaDe | undefined;
  public deleteAcercaDe:acercaDe | undefined;

  constructor(private acercaDeService: AcercaDeService){}

  ngOnInit(): void {
    this.getAcercaDe();
  }

  public getAcercaDe():void{
    this.acercaDeService.getAcercaDe().subscribe({
      next:(Response: acercaDe[]) =>{
        this.acercaDe=Response;
      },
      error:(error:HttpErrorResponse) => {
        alert(error.message);
      }
    })
  }
  

  public onOpenModal(mode:String, acercaDe?: acercaDe):void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if(mode==='add'){
      button.setAttribute('data-target', '#addAcercaDeModal');
    } else if (mode==='delete') {
      this.deleteAcercaDe = acercaDe;
      button.setAttribute('data-target', '#deleteAcercaDeModal');
    } else if (mode==='edit') {
      this.editAcercaDe = acercaDe;
      button.setAttribute('data-target', '#editAcercaDeModal');
    }

    container?.appendChild(button);
    button.click();
  }
  
  public onAddAcercaDe(addForm: NgForm){
    document.getElementById('add-acercaDe-form')?.click();
    this.acercaDeService.addAcercaDe(addForm.value).subscribe({
        next: (response:acercaDe) => {
          console.log(response);
          this.getAcercaDe();
          addForm.reset();
        },
        error:(error:HttpErrorResponse) => {
          alert(error.message);
          addForm.reset();
        }
      }
    )
  }

  public onUpdateAcercaDe(acercaDe: acercaDe){
    this.editAcercaDe=acercaDe;
    document.getElementById('add-acercaDe-form')?.click();
    this.acercaDeService.updateAcercaDe(acercaDe).subscribe({
        next: (response:acercaDe) => {
          console.log(response);
          this.getAcercaDe();
        },
        error:(error:HttpErrorResponse) => {
          alert(error.message);
        }
      }
    )
  }

  public onDeleteAcercaDe(idAcerca: number){
    this.acercaDeService.deleteAcercaDe(idAcerca).subscribe({
        next: (response:void) => {
          console.log(response);
          this.getAcercaDe();
        },
        error:(error:HttpErrorResponse) => {
          alert(error.message);
        }
      }
    )
  }

}

