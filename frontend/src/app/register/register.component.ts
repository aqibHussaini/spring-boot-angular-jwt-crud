import { Component, OnInit } from '@angular/core';
import { user } from '../User';
import {UserServiceService} from '../user-service.service';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
 public obj:user;
  constructor(private service:UserServiceService) {
   this.obj=new user("","");
   }

  ngOnInit(): void {
  }
  register(){
this.service.doRegister(this.obj);
    console.log(this.obj);
  }
}
