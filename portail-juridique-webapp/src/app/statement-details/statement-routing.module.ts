import {NgModule} from "@angular/core";
import {Routes, RouterModule} from "@angular/router";
import {StatementDetailsComponent} from "./statement-details.component";
import {RightHolderComponent} from "./right-holder/right-holder.component";

const routes: Routes = [
  {
    path: 'statement/:id',
    component: StatementDetailsComponent
  },
  {
    path: "statement/:id/right_holder/new",
    component: RightHolderComponent
  }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class StatementRoutingModule {
}

