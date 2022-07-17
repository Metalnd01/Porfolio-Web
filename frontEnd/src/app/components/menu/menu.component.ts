import { Component, NgModule, OnInit } from '@angular/core';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { AppModule } from 'src/app/app.module';
import { TokenService } from 'src/app/servicios/token.service';
import { LoginComponent } from '../login/login.component';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  isLogged=false;


  constructor(private router:Router, private tokenService:TokenService) {}

  ngOnInit(): void {
    if(this.tokenService.getToken()){
      this.isLogged=true;
    } else {
      this.isLogged=false;
    }
  }

  onLogOut(): void{
    this.tokenService.logOut();
    window.location.reload();
  }

  login(){
    this.router.navigate(["/login"])
  }

}
