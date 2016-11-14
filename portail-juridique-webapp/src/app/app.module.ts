import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {AppComponent} from "./app.component";
import {HttpModule} from "@angular/http";
import {StatementDetailsComponent} from "./statement-details/statement-details.component";
import {PotailJuridiqueWebappRoutingModule} from "./app-routing.module";
import {StatementService} from "./shared/statement.service";
import {DashboardModule} from "./dashboard/dashboard.module";
import { RightHolderComponent } from './statement-details/right-holder/right-holder.component';
import {StatementDetailsModule} from "./statement-details/statement-details.module";
import {RightHolderService} from "./statement-details/right-holder/right-holder.service";


@NgModule({
  declarations: [
    AppComponent,
    RightHolderComponent
  ],
  imports: [
    BrowserModule,
    DashboardModule,
    StatementDetailsModule,
    FormsModule,
    PotailJuridiqueWebappRoutingModule,
    HttpModule
  ],
  providers: [StatementService,RightHolderService],
  bootstrap: [AppComponent]
})
export class AppModule {
}



