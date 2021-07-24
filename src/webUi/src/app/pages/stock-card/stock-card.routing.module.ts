import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {StockCardComponent} from "./stock-card.component";

const routes: Routes = [
    {
        path: '',
        component: StockCardComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})

export class StockCardRoutingModule{ }

