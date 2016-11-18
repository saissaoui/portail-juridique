import {Component, OnInit} from '@angular/core';
import {RightholderRole} from "./right-holder-role.model";
import {RightHolderService} from "./right-holder.service";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {Headers} from "@angular/http";
import {RightHolder} from "./right-holder.model";

@Component({
  selector: 'app-right-holder',
  templateUrl: './right-holder.component.html',
  styleUrls: ['./right-holder.component.css']
})
export class RightHolderComponent implements OnInit {

  roles: RightholderRole[];
  rightHolder: RightHolder;
  statementId: number;
  errorMessage: string;

  constructor(private rightHolderService: RightHolderService, private route: ActivatedRoute, private router: Router) {
  }


  ngOnInit() {
    this.initRolesList();
    this.route.params.forEach((params: Params) => {
      this.statementId = +params['id'];
    });
    this.rightHolder =  new RightHolder();

  }

  private initRolesList(): void {
    this.rightHolderService.getAvailableRoles().subscribe(
      roles => this.roles = roles,
      error => this.errorMessage = <any>error
    )

  }

  addRightHolderToStatement(): void {
    this.rightHolder.statementId = this.statementId;
    this.rightHolder.partnerId = 5;
    this.rightHolderService.addRightHolderToStatement(this.rightHolder).subscribe(
      () => this.goBack(),
      error => this.errorMessage = <any>error
    );
  }

  goBack() {
    this.router.navigate(["statement", this.statementId]);
  }

}
