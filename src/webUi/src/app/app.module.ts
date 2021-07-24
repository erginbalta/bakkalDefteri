import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app.routing.module';
import { AppComponent } from './app.component';
import { StockCardComponent } from './pages/stock-card/stock-card.component';
import { ProductCardComponent } from './pages/product-card/product-card.component';
import { OutgoingInvoicesComponent } from './pages/outgoing-invoices/outgoing-invoices.component';
import { IncomingInvoicesComponent } from './pages/incoming-invoices/incoming-invoices.component';
import { DashbordComponent } from './pages/dashbord/dashbord.component';
import { CustomersComponent } from './pages/customers/customers.component';
import { SuppliersComponent } from './pages/suppliers/suppliers.component';
import { CategoriesComponent } from './pages/categories/categories.component';
import { UserComponent } from './pages/user/user.component';
import { LoginComponent } from './login/login.component';
import {AppLayoutComponent} from "./_layout/app-layout/app-layout.component";
import {FooterComponent} from "./_layout/footer/footer.component";
import {HeaderComponent} from "./_layout/header/header.component";
import {SlidebarComponent} from "./_layout/slidebar/slidebar.component";

@NgModule({
  declarations: [
    AppComponent,
    StockCardComponent,
    ProductCardComponent,
    OutgoingInvoicesComponent,
    IncomingInvoicesComponent,
    DashbordComponent,
    CustomersComponent,
    SuppliersComponent,
    CategoriesComponent,
    UserComponent,
    LoginComponent,
    AppLayoutComponent,
    FooterComponent,
    HeaderComponent,
    SlidebarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
