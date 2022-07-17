import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { persona } from 'src/app/model/persona.model';
import { PersonaService } from 'src/app/servicios/persona.service';
import { TokenService } from 'src/app/servicios/token.service';


@Component({
  selector: 'app-encabezado',
  templateUrl: './encabezado.component.html',
  styleUrls: ['./encabezado.component.css']
})
export class EncabezadoComponent implements OnInit {
  public persona: persona | undefined;
  public editPersona:persona | undefined;
  public deletePersona:persona | undefined;

  constructor(public personaService: PersonaService, private tokenService: TokenService) { }

  isLogged = false;
  
  ngOnInit(): void {
    this.getPersona();
    if (this.tokenService.getToken()){
      this.isLogged = true;
    }else{
      this.isLogged = false;
    }
  }

  public getPersona():void{
    this.personaService.getPersona().subscribe({
      next: (response: persona) => {
        this.persona=response;
      },
      error:(error:HttpErrorResponse) => {
        alert(error.message);
      }
    })
  }

  public onOpenModal(mode:String, persona?: persona):void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if(mode==='add'){
      button.setAttribute('data-target', '#addPersonaModal');
    } else if (mode==='delete') {
      this.deletePersona = persona;
      button.setAttribute('data-target', '#deletePersonaModal');
    } else if (mode==='edit') {
      this.editPersona = persona;
      button.setAttribute('data-target', '#editPersonaModal');
    }

    container?.appendChild(button);
    button.click();
  }

  public onUpdatePersona(persona: persona){
    this.editPersona=persona;
    document.getElementById('add-persona-form')?.click();
    this.personaService.updatePersona(persona).subscribe({
        next: (response:persona) => {
          console.log(response);
          this.getPersona();
        },
        error:(error:HttpErrorResponse) => {
          alert(error.message);
        },
    })
  }
}
