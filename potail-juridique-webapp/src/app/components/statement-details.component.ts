import {Component, OnInit, Input} from "@angular/core";
import {ActivatedRoute, Params} from "@angular/router";
import {Location} from "@angular/common";
import {Statement} from "../model/statement";
import {StatementService} from "../services/statement.service";

@Component({
  selector: 'statement-details',
  templateUrl: '../views/statement-details.component.html'
})
export class StatementDetailsComponent implements OnInit {

  statement: Statement;
  errorMessage: string;

  constructor(private statementService: StatementService, private route: ActivatedRoute,
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

  goBack(): void {
    this.location.back();
  }
}
