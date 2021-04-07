import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MatSliderModule } from '@angular/material/slider';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import {MatTableModule} from '@angular/material/table';
import {MatCardModule} from '@angular/material/card';
import { HttpClientModule } from '@angular/common/http';
import {MatPaginatorModule} from '@angular/material/paginator';
import { AddComponent } from './add/add.component';
import { StudentformComponent } from './studentform/studentform.component';
import { HeaderComponent } from './header/header.component';
import { AddtodoComponent } from './addtodo/addtodo.component';
import { FormsModule } from '@angular/forms';
import { VietodoComponent } from './vietodo/vietodo.component';
import { UpdatetodoComponent } from './updatetodo/updatetodo.component';
import { ViewProductsComponent } from './view-products/view-products.component';
import { AddProductComponent } from './add-product/add-product.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
@NgModule({
  declarations: [
    AppComponent,
    AddComponent,
    StudentformComponent,
    HeaderComponent,
    AddtodoComponent,
    VietodoComponent,
    UpdatetodoComponent,
    ViewProductsComponent,
    AddProductComponent,
    UpdateProductComponent,
    RegisterComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSliderModule,
    MatButtonModule,
    MatTableModule,
    HttpClientModule,
    MatPaginatorModule,
    MatCardModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
