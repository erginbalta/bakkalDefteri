import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IncomingInvoicesRoutingModule } from './incoming-invoices.routing.module';
import { IncomingInvoicesComponent } from './incoming-invoices.component';



@NgModule({
  declarations: [IncomingInvoicesComponent],
  imports: [
    CommonModule,
    IncomingInvoicesRoutingModule
  ]
})
export class IncomingInvoicesModule { }
