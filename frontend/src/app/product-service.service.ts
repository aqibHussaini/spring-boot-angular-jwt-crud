import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {
  private token = '';
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': this.token
    })
  };
  constructor(private http: HttpClient) {
    this.token = 'Bearer ' + localStorage.getItem('token');
  }
  public getAllProducts() {
    const headers = { 'Authorization': this.token }

    let response = this.http.get("http://localhost:8080/view-all-product", { headers });
    return response;
  }
  public save(object, fileToUpload) {
    const headers = { 'Authorization': this.token }
    console.log(object);
    let formData = new FormData();
    console.log(fileToUpload);
    formData.append("pic", fileToUpload);

    console.log(formData.get("pic"));
    formData.append("name", object.name);
    formData.append("category", object.category);
    formData.append("price", object.price);
    // let res1 = this.http.post("http://localhost:8080/register", {id:1,password:"ali",user_name:"ali"});
    // res1.subscribe(d => { console.log(d) });

    let res = this.http.post("http://localhost:8080/add-product", formData, { headers });
    res.subscribe(d => { console.log(d) });

  }
  getProductById(id) {


    const headers = { 'Authorization': this.token }
    return this.http.get("http://localhost:8080/get-product-by-id/" + id, { headers });
  }
  delete(id) {
    const headers = { 'Authorization': this.token }
    return this.http.delete("http://localhost:8080/delete-product/" + id, { headers });
  }
  search(query)
  {
    const headers = { 'Authorization': this.token }
console.log(query);
let res=this.http.get("http://localhost:8080/get-product-by-name/" +query, { headers });
res.subscribe(d=>{
  console.log(d);
});

  }
  updateProduct(obj, file) {
    const headers = { 'Authorization': this.token }
    var formData = new FormData();

    formData.append("pic", file);
    formData.append("name", obj.name);
    formData.append("category", obj.category);
    formData.append("price", obj.price);
    // console.log(formData.get("pic"));
    // console.log(formData.get("name"));
    // console.log(formData.get("category"));
    // console.log(formData.get("price"));
    return this.http.put("http://localhost:8080/update-product/" + obj.id, formData, { headers });
  }
}
