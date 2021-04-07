import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class AddService {
fn:number;
sn:number;
  constructor(public httpClient: HttpClient) { }
  addtwonum()
  {
   var std='http://localhost:9090/student-app/getAllStudent';
  //  let resp=this.httpClient.post('http://localhost:9090/add',{firstnumber:1,secondnumber:101});
  //  resp.subscribe(res=>{
  //     console.log(res);
  //   })
    //  this.httpClient.get(std);
    let response=this.httpClient.get(std);
    response.subscribe(res=>{
    
      console.log(res);
    })
    
  }
}
