import {Component, OnInit} from '@angular/core';
import {RightholderRole} from "./right-holder-role.model";
import {RightHolderService} from "./right-holder.service";

@Component({
  selector: 'app-right-holder',
  templateUrl: './right-holder.component.html',
  styleUrls: ['./right-holder.component.css']
})
export class RightHolderComponent implements OnInit {

  roles: RightholderRole[];
  errorMessage:string;

  constructor(private rightHolderService: RightHolderService)
  {}


  ngOnInit() {
    this.initRolesList();
  }

  private initRolesList(): void {
    this.rightHolderService.getAvailableRoles().subscribe(
      roles => this.roles = roles,
      error => this.errorMessage = <any>error
    )

  }

}
