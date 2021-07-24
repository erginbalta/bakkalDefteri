import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OutgoingInvoicesRoutingModule } from './outgoing-invoices.routing.module';
import { OutgoingInvoicesComponent } from './outgoing-invoices.component';



@NgModule({
  declarations: [OutgoingInvoicesComponent],
  imports: [
    CommonModule,
    OutgoingInvoicesRoutingModule
  ]
})
export class OutgoingInvoicesModule { }
