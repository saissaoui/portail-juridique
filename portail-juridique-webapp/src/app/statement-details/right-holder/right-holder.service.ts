import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {RightholderRole} from "./right-holder-role.model";

@Injectable()
export class RightHolderService {

  constructor() {
  }

  getAvailableRoles(): Observable<RightholderRole[]> {
    return Observable.of(
      [
        {
          roleCode: "code",
          roleLabel: "label"
        }
      ]);
  }

}
