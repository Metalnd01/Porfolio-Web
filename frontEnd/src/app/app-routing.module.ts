import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';

import { LoginComponent } from './components/login/login.component';
import { PorfolioComponent } from './components/porfolio/porfolio.component';
import { GuardGuard } from './servicios/guard.guard';

const routes: Routes = [
  {path: "porfolio", component:PorfolioComponent, canActivate:[GuardGuard]},
  {path: "login", component:LoginComponent},
  {path: '', redirectTo:"login", pathMatch:"full"},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
