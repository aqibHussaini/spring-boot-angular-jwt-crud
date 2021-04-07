import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddComponent } from './add/add.component';
import{HeaderComponent}from'./header/header.component';
import { StudentformComponent } from './studentform/studentform.component';
import{AddtodoComponent}from'./addtodo/addtodo.component';
import{VietodoComponent}from'./vietodo/vietodo.component';
import{UpdatetodoComponent}from'./updatetodo/updatetodo.component';
import{ViewProductsComponent}from'./view-products/view-products.component';
import{AddProductComponent}from'./add-product/add-product.component';
import{UpdateProductComponent} from './update-product/update-product.component' ;
import{RegisterComponent} from './register/register.component' ;
import{LoginComponent} from './login/login.component' ;
const routes: Routes = [
  { path: 'add', component: AddComponent },
  { path: 'stdform', component: StudentformComponent },
  { path: 'todoform', component: AddtodoComponent },
  {path:'view',component:VietodoComponent},
  {path:'updateform/:id',component:UpdatetodoComponent},
  {path:'view-products',component:ViewProductsComponent},
  {path:'add-products',component:AddProductComponent},
  { path:'app-update-product/:id', component:UpdateProductComponent},
  {path:'app-register',component:RegisterComponent},
  {path:'app-login',component:LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
