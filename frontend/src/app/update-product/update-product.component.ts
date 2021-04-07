import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {Router} from '@angular/router';
import{ProductServiceService} from'../product-service.service';
@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {
  public obj;
  constructor(private service:ProductServiceService ,private route:ActivatedRoute,private router:Router) { }
public fileToUpload;
  ngOnInit(): void {
    let id=this.route.snapshot.params['id'];
    let resp=this.service.getProductById(id);
    resp.subscribe(data=>{
this.obj=data;
    });
  }
  getFile(event) {
    this.fileToUpload = event.target.files[0];
    // this.obj.pic=this.fileToUpload;
    console.log(this.fileToUpload,this.obj.pic);
}
  update(obj)
  {
   let res= this.service.updateProduct(obj,this.fileToUpload);
   res.subscribe(d=>{
     console.log("hello response ="+d);
     this.router.navigate(['view-products']);
   });
  }

}
