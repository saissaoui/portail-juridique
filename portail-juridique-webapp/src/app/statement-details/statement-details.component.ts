import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {Location} from "@angular/common";
import {StatementService} from "../shared/statement.service";
import {Statement} from "../shared/statement.model";

@Component({
  selector: 'statement-details',
  templateUrl: './statement-details.component.html'
})
export class StatementDetailsComponent implements OnInit {

  statement: Statement;
  errorMessage: string;

  constructor(private statementService: StatementService, private route: ActivatedRoute,private router: Router,
              private location: Location) {
  }

  ngOnInit() {
    this.getStatement();
  }

  private getStatement():void {
    this.route.params.forEach((params: Params) => {
      let id = +params['id'];
      this.statementService.getStatement(id).subscribe(
        statement => this.statement = statement,
        error => this.errorMessage = <any>error);
    });
  }

  goBack()
  {
    this.router.navigate(["/dashboard"]);
  }
}
