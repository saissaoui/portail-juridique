import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {RightholderRole} from "./right-holder-role.model";
import {Http, Response, Headers, RequestOptions} from "@angular/http";
import {environment} from "../../../environments/environment";
import {RightHolder} from "./right-holder.model";
import {WsClient} from "../../shared/ws-client";

@Injectable()
export class RightHolderService {

  private uriTemplate = "right_holders";

  constructor(private wsClient: WsClient) {
  }

  getAvailableRoles(): Observable<RightholderRole[]> {
    return Observable.of(
      [
        {
          roleCode: "ACT",
          roleLabel: "Acteur"
        }
      ]);
  }

  addRightHolderToStatement(rightHolder: RightHolder): Observable<any> {

    return this.wsClient.post(this.uriTemplate,null,rightHolder)
      .map(this.extractData)
      .catch(this.handleError);
  }

  private extractData(res: Response) {
    let body = res.json();
    return body || {};
  }

  private handleError(error: any): Observable<any> {
    // In a real world app, we might use a remote logging infrastructure
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }

}
