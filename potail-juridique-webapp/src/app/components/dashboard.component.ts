import {Component, OnInit} from '@angular/core';
import {Statement} from "../model/statement";
import {Router} from "@angular/router";

@Component({
  selector: 'dashboard',
  templateUrl: '../views/dashboard.component.html'
})
export class DashboardComponent implements OnInit {


  constructor() {
  }

  ngOnInit() {

  }

 /* gotoStatementDetail(statement: Statement):void{
    let link = ['/statement', statement.id];
    this.router.navigate(link);

  }*/

}
