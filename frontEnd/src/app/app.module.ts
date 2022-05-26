import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { NgCircleProgressModule } from 'ng-circle-progress';

import { AppComponent } from './app.component';

import { LoginComponent } from './components/login/login.component'; 
import { GraficosComponent } from './components/graficos/graficos.component';
import { PorfolioComponent } from './components/porfolio/porfolio.component';
import { IdiomasComponent } from './components/idiomas/idiomas.component';
import { AcercaComponent } from './components/acerca/acerca.component';
import { EducacionComponent } from './components/educacion/educacion.component';
import { ExperienciaComponent } from './components/experiencia/experiencia.component';
import { SkillsComponent } from './components/skills/skills.component';
import { ProyectosComponent } from './components/proyectos/proyectos.component';
import { FooterComponent } from './components/footer/footer.component';
import { EncabezadoComponent } from './components/encabezado/encabezado.component';
import { MenuComponent } from './components/menu/menu.component';
import { PorfolioService } from './servicios/porfolio.service';
import { InterceptorService } from './servicios/interceptor.service';

@NgModule({
  declarations: [
    IdiomasComponent,
    AcercaComponent,
    LoginComponent,
    GraficosComponent,
    PorfolioComponent,
    EducacionComponent,
    ExperienciaComponent,
    SkillsComponent,
    ProyectosComponent,
    FooterComponent,
    EncabezadoComponent,
    MenuComponent,
    AppComponent,
  ],
  imports: [  
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule,
    ReactiveFormsModule,
    NgCircleProgressModule.forRoot({}),
    
  ],
  providers: [PorfolioService, {provide: HTTP_INTERCEPTORS, useClass:InterceptorService, multi:true},],
  bootstrap: [AppComponent]
})
export class AppModule { }
