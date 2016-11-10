import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {DashboardComponent} from "./dashboard.component";
import {StatementsComponent} from "./statements/statements.component";
import {DashboardRoutingModule} from "./dashboard-routing.modute";
import {StatementRoutingModule} from "../statement-details/statement-routing.module";

@NgModule({
  imports: [
    CommonModule,
    DashboardRoutingModule,
    StatementRoutingModule
  ],
  declarations: [
    DashboardComponent,
    StatementsComponent
  ]
})
export class DashboardModule {
}
