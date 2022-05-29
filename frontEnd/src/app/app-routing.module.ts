import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';


import { AppComponent } from './app.component';

import { LoginComponent } from './components/login/login.component';
import { persona } from './model/persona.model';

const routes: Routes = [
  /*{path: "persona", component:PersonaComponent},*/
  {path: "login", component: LoginComponent},
  {path: "", redirectTo:"/porfolio", pathMatch:"full"},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
