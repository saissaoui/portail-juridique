import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {DashboardComponent} from "./dashboard.component";
import {StatementsComponent} from "./statements/statements.component";
import {DashboardRoutingModule} from "./dashboard-routing.modute";

@NgModule({
  imports: [
    CommonModule,
    DashboardRoutingModule
  ],
  declarations: [DashboardComponent,
    StatementsComponent]
})
export class DashboardModule {
}
