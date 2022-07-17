import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { proyectos } from 'src/app/model/proyectos.model';
import { ProyectosService } from 'src/app/servicios/proyectos.service';
import { Modal } from 'bootstrap';
import { Container } from '@angular/compiler/src/i18n/i18n_ast';
import { TokenService } from 'src/app/servicios/token.service';

@Component({
  selector: 'app-proyectos',
  templateUrl: './proyectos.component.html',
  styleUrls: ['./proyectos.component.css']
})
export class ProyectosComponent implements OnInit {

  public proyectos:proyectos[] = [];
  public editProyectos:proyectos | undefined;
  public deleteProyectos:proyectos | undefined;
  public testModal:Modal | undefined;

  constructor(private proyectosService: ProyectosService, private tokenService:TokenService){}

  isLogged = false;

  ngOnInit(): void {
    this.getProyectos();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else{
      this.isLogged = false;
    }
  }

  public getProyectos():void{
    this.proyectosService.getProyectos().subscribe({
      next:(Response: proyectos[]) =>{
        this.proyectos=Response;
      },
      error:(error:HttpErrorResponse) => {
        alert(error.message);
      }
    })
  }
  

  public onOpenModal(mode:String, proyectos?: proyectos):void {
    let el_testModal = document.getElementById('testModal');
    if (el_testModal) {
      this.testModal=new Modal(el_testModal, {
        keyboard: false
      });
      this.testModal?.show();}
    const button = document.createElement('button');
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if(mode==='add'){
      button.setAttribute('data-target', '#addProyectosModal');
    } else if (mode==='delete') {
      this.deleteProyectos = proyectos;
      button.setAttribute('data-target', '#deleteProyectosModal');
    } else if (mode==='edit') {
      this.editProyectos = proyectos;
      button.setAttribute('data-target', '#editProyectosModal');
    }

    el_testModal?.appendChild(button);
    button.click();
  }
  
  public onAddProyectos(addForm: NgForm){
    document.getElementById('add-proyectos-form')?.click();
    this.proyectosService.addProyectos(addForm.value).subscribe({
        next: (response:proyectos) => {
          console.log(response);
          this.getProyectos();
          addForm.reset();
        },
        error:(error:HttpErrorResponse) => {
          alert(error.message);
          addForm.reset();
        }
      }
    )
  }

  public onUpdateProyectos(proyectos: proyectos){
    this.editProyectos=proyectos;
    document.getElementById('add-proyectos-form')?.click();
    this.proyectosService.updateProyectos(proyectos).subscribe({
        next: (response:proyectos) => {
          console.log(response);
          this.getProyectos();
        },
        error:(error:HttpErrorResponse) => {
          alert(error.message);
        }
      }
    )
  }

  public onDeleteProyectos(idProy: number):void{
    this.proyectosService.deleteProyectos(idProy).subscribe({
        next: (response:void) => {
          console.log(response);
          this.getProyectos();
        },
        error:(error:HttpErrorResponse) => {
          alert(error.message);
        }
      }
    )
  }

}
