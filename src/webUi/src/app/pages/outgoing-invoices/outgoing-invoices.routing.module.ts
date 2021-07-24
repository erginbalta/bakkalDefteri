import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {OutgoingInvoicesComponent} from "./outgoing-invoices.component";

const routes: Routes = [
    {
        path: '',
        component: OutgoingInvoicesComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})

export class OutgoingInvoicesRoutingModule{ }

