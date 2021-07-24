import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StockCardRoutingModule } from './stock-card.routing.module';
import { StockCardComponent } from './stock-card.component';



@NgModule({
  declarations: [StockCardComponent],
  imports: [
    CommonModule,
    StockCardRoutingModule
  ]
})
export class StockCardModule { }
