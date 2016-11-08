import {Component, OnInit} from '@angular/core';
import {Statement} from "../model/statement";
import {StatementService} from "../services/statement.service";

@Component({
  selector: 'statements-list',
  templateUrl: '../views/statements.component.html'

})
export class StatementsComponent implements OnInit {

  statements: Statement[];
  selected: Statement;
  errorMessage: string;


  constructor(private statementService: StatementService) {
  }

  ngOnInit() {

    this.getStatements();
  }

  private getStatements(): void {
    this.statementService.getStatements().subscribe(
      statements => this.statements = statements,
      error =>  this.errorMessage = <any>error);
  }

  onSelect(statement: Statement) {
    this.selected = statement;
  }
}
