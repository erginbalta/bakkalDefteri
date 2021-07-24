import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {IncomingInvoicesComponent} from "./incoming-invoices.component";

const routes: Routes = [
    {
        path: '',
        component: IncomingInvoicesComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})

export class IncomingInvoicesRoutingModule{ }

