import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';


import { AppComponent } from './app.component';

import { LoginComponent } from './components/login/login.component';
import { PorfolioComponent } from './components/porfolio/porfolio.component';

const routes: Routes = [
  {path: "porfolio", component:PorfolioComponent},
  {path: "login", component: LoginComponent},
  {path: "", redirectTo:"/porfolio", pathMatch:"full"},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
