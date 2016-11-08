import {Injectable} from "@angular/core";
import {Headers, Http, Response} from '@angular/http';

import 'rxjs/add/operator/toPromise';
import {Statement} from "../model/statement";
import {Observable} from "rxjs";

const statements: Statement[] = [
  {
    'id': 2,
    'title': 'statement 1',
    'lastActivityDate': '04/11/2016',
    'status': 'PENDING',
    producerOwnerId: null,
    hasNoArtworks: false
  },
  {
    'id': 2,
    'title': 'statement 2',
    'lastActivityDate': '04/11/2016',
    'status': 'PENDING',
    producerOwnerId: null,
    hasNoArtworks: false
  }
];


@Injectable()
export class StatementService {
  private statementsUrl = "http://localhost:8080/daj-ws/statements";
  private statementDetailsUrl = "http://localhost:8080/daj-ws/statements/";

  constructor(private http: Http) {
  }

  getStatements(): Observable<Statement[]> {
    return this.http.get(this.statementsUrl)
     .map(this.extractData)
     .catch(this.handleError);
  }

  getStatement(id: number): Observable<Statement> {
    return this.http.get(this.statementDetailsUrl+id)
      .map(this.extractData)
      .catch(this.handleError);
  }

  private extractData(res: Response)
  {
    let body = res.json();
    return body || { };
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
