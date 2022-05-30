import { HttpErrorResponse, HttpRequest } from '@angular/common/http';
import { error } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { educacion } from 'src/app/model/educacion.model';
import { EducacionService } from 'src/app/servicios/educacion.service';

@Component({
  selector: 'app-educacion',
  templateUrl: './educacion.component.html',
  styleUrls: ['./educacion.component.css']
})
export class EducacionComponent implements OnInit {
  
  public educations:educacion[]=[];
  public editEducations:educacion | undefined;
  public deleteEducations:educacion | undefined;

  constructor(private educacionService:EducacionService) { }

  ngOnInit(): void {
    this.getEducations();
  }

  public getEducations():void{
    this.educacionService.getEducacion().subscribe({
      next:(Response: educacion[]) =>{
        this.educations=Response;
      },
      error:(error:HttpErrorResponse) => {
        alert(error.message);
      }
    })
  }

  public onOpenModal(mode:String, educacion?: educacion):void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if(mode==='add'){
      button.setAttribute('data-target', '#addEducationsModal');
    } else if (mode==='delete') {
      this.deleteEducations = educacion;
      button.setAttribute('data-target', '#deleteEducationsModal');
    } else if (mode==='edit') {
      this.editEducations = educacion;
      button.setAttribute('data-target', '#editEducationsModal');
    }

    container?.appendChild(button);
    button.click();
  }
  
  public onAddEducations(addForm: NgForm){
    document.getElementById('add-educacion-form')?.click();
    this.educacionService.addEducacion(addForm.value).subscribe({
        next: (response:educacion) => {
          console.log(response);
          this.getEducations();
          addForm.reset();
        },
        error:(error:HttpErrorResponse) => {
          alert(error.message);
          addForm.reset();
        }
      }
    )
  }

  public onUpdateEducations(educacion: educacion){
    this.editEducations=educacion;
    document.getElementById('add-educacion-form')?.click();
    this.educacionService.updateEducacion(educacion).subscribe({
        next: (response:educacion) => {
          console.log(response);
          this.getEducations();
        },
        error:(error:HttpErrorResponse) => {
          alert(error.message);
        }
      }
    )
  }

  public onDeleteEducations(idEdu: number):void{
    this.educacionService.deleteEducacion(idEdu).subscribe({
        next: (response:void) => {
          console.log(response);
          this.getEducations();
        },
        error:(error:HttpErrorResponse) => {
          alert(error.message);
        }
      }
    )
  }
}
