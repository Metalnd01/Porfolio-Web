import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { graficos } from 'src/app/model/graficos.model';
import { GraficosService } from 'src/app/servicios/graficos.service';
import { TokenService } from 'src/app/servicios/token.service';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {

  public graficos:graficos[] = [];
  public editGraficos:graficos | undefined;
  public deleteGraficos:graficos | undefined;


  constructor(private graficosService: GraficosService, private tokenService: TokenService){}

  isLogged = false;

  ngOnInit(): void {
    this.getGraficos();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else{
      this.isLogged = false;
    }
  }

  public getGraficos():void{
    this.graficosService.getGraficos().subscribe({
      next:(Response: graficos[]) =>{
        this.graficos=Response;
      },
      error:(error:HttpErrorResponse) => {
        alert(error.message);
        console.log('aca esta el error');
      }
    })
  }
  

  public onOpenModal(mode:String, graficos?: graficos):void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if(mode==='add'){
      button.setAttribute('data-target', '#addGraficosModal');
    } else if (mode==='delete') {
      this.deleteGraficos = graficos;
      button.setAttribute('data-target', '#deleteGraficosModal');
    } else if (mode==='edit') {
      this.editGraficos = graficos;
      button.setAttribute('data-target', '#editGraficosModal');
    }

    container?.appendChild(button);
    button.click();
  }
  
  public onAddGraficos(addForm: NgForm){
    document.getElementById('add-graficos-form')?.click();
    this.graficosService.addGraficos(addForm.value).subscribe({
        next: (response:graficos) => {
          console.log(response);
          this.getGraficos();
          addForm.reset();
        },
        error:(error:HttpErrorResponse) => {
          alert(error.message);
          addForm.reset();
        }
      }
    )
  }
}
