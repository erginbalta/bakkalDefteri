import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {DashbordComponent} from "./pages/dashbord/dashbord.component";
import {CategoriesComponent} from "./pages/categories/categories.component";
import {CustomersComponent} from "./pages/customers/customers.component";
import {SuppliersComponent} from "./pages/suppliers/suppliers.component";
import {IncomingInvoicesComponent} from "./pages/incoming-invoices/incoming-invoices.component";
import {OutgoingInvoicesComponent} from "./pages/outgoing-invoices/outgoing-invoices.component";
import {ProductCardComponent} from "./pages/product-card/product-card.component";
import {StockCardComponent} from "./pages/stock-card/stock-card.component";
import {UserComponent} from "./pages/user/user.component";
import {LoginComponent} from "./login/login.component";
import {AppLayoutComponent} from "./_layout/app-layout/app-layout.component";

const routes: Routes = [
    {
        path: '', component: AppLayoutComponent,
        children: [
            {path: '', pathMatch: 'full', redirectTo: '/login'},
            {path: 'dashbord', component: DashbordComponent},
            {path: 'categories', component: CategoriesComponent},
            {path: 'customers', component: CustomersComponent},
            {path: 'suppliers', component: SuppliersComponent},
            {path: 'incoming-invoices', component: IncomingInvoicesComponent},
            {path: 'outgoing-invoices', component: OutgoingInvoicesComponent},
            {path: 'product-card', component: ProductCardComponent},
            {path: 'stock-card', component: StockCardComponent},
            {path: 'user', component: UserComponent}
        ]
    },
    {path: 'login', component: LoginComponent},
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule{ }
