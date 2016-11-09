import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {AppComponent} from "./app.component";
import {HttpModule} from "@angular/http";
import {StatementDetailsComponent} from "./shared/statement-details/statement-details.component";
import {PotailJuridiqueWebappRoutingModule} from "./app-routing.module";
import {StatementService} from "./shared/statement.service";
import {DashboardModule} from "./dashboard/dashboard.module";


@NgModule({
  declarations: [
    AppComponent,
    StatementDetailsComponent
  ],
  imports: [
    BrowserModule,
    DashboardModule,
    FormsModule,
    PotailJuridiqueWebappRoutingModule,
    HttpModule
  ],
  providers: [StatementService],
  bootstrap: [AppComponent]
})
export class AppModule {
}



