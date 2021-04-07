import { Component, OnInit } from '@angular/core';
import { ProductServiceService } from '../product-service.service';
import { Router, RouterModule } from '@angular/router';
@Component({
  selector: 'app-view-products',
  templateUrl: './view-products.component.html',
  styleUrls: ['./view-products.component.css']
})
export class ViewProductsComponent implements OnInit {
  products: any;
  private query:string;
  constructor(public service: ProductServiceService,private router:Router) { }

  ngOnInit(): void {
    let response = this.service.getAllProducts();
    response.subscribe(data => {
      this.products = data;
      // for (var product of this.products) {
      //   console.log(product.id);
      // }

    });
  }
deleteProduct(id){
 let resp=this.service.delete(id);
 resp.subscribe(d=>{console.log(d)});
}
editProduct(id){
  this.router.navigate(['app-update-product',id]);
}
search()
{
  console.log(this.query);
  this.service.search(this.query);
}
}
