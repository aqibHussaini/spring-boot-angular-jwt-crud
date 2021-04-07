import { Component, OnInit } from '@angular/core';
import {Product} from '../product';
import{ProductServiceService} from'../product-service.service';
@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
   obj:Product=new Product('samsung','mobile','phone.jpg',3000);
   private fileToUpload=null;
  constructor(private service:ProductServiceService) { }

  ngOnInit(): void {
  }
  getFile(event) {
    this.fileToUpload = event.target.files[0];
    // this.obj.pic=this.fileToUpload;
    // console.log(this.fileToUpload,this.obj.pic);
}
handle(){
let res=this.service.save(this.obj,this.fileToUpload);
// res.subscribe(a=>{console.log(a)});
}
}
