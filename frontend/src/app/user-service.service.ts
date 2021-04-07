import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private http: HttpClient) { }
  doRegister(obj) {
    obj
    console.log(obj);
    let res = this.http.post("http://localhost:8080/register", obj);
    res.subscribe(d => {
      console.log(d);
    });
  }
  doLogin(obj) {
    let res = this.http.post("http://localhost:8080/get-token", obj);
    res.subscribe(d => {
if(d!=null)
{
  localStorage.setItem('token',d.jwt_token);
}
      
      console.log(localStorage.getItem('token'));
    });
  }
}
