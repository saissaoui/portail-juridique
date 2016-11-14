import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {StatementDetailsComponent} from "./statement-details.component";
import {StatementRoutingModule} from "./statement-routing.module";

@NgModule({
  imports: [
    CommonModule,
    StatementRoutingModule
  ],
  declarations: [StatementDetailsComponent]
})
export class StatementDetailsModule { }
