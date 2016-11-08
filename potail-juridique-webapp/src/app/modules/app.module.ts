import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {AppComponent} from "../components/app.component";
import {StatementDetailsComponent} from "../components/statement-details.component";
import {PotailJuridiqueWebappRoutingModule} from "./app-routing.module";
import {StatementsComponent} from "../components/statements.component";
import {StatementService} from "../services/statement.service";
import {DashboardComponent} from "../components/dashboard.component";
import {HttpModule} from "@angular/http";


@NgModule({
  declarations: [
    AppComponent,
    StatementDetailsComponent,
    StatementsComponent,
    DashboardComponent,
   //
  ],
  imports: [
    BrowserModule,
    FormsModule,
    PotailJuridiqueWebappRoutingModule,
    HttpModule
  ],
  providers: [StatementService],
  bootstrap: [AppComponent]
})
export class AppModule { }



