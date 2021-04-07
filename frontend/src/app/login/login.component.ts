import { Component, OnInit } from '@angular/core';
import { from } from 'rxjs';
import { req } from '../jwtReq';
import{UserServiceService} from'../user-service.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
public obj:req;
  constructor(private service:UserServiceService) {
    this.obj=new req("","");
   }

  ngOnInit(): void {
  }
Login()
{
 this.service.doLogin(this.obj);
 
}
}
