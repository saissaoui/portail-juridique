import {Injectable, Inject} from '@angular/core';
import {Http, Response, Headers} from '@angular/http';
import {APP_CONFIG} from '../shared/app-config';
import * as uriTemplates from 'uri-templates';
import {Observable}   from 'rxjs/Observable';

@Injectable()
export class WsClient {

  private apiHost;
  private headers = new Headers({'Content-Type': 'application/json'});

  constructor(private http: Http, @Inject(APP_CONFIG) private config: any) {
    this.apiHost = `${this.config.scheme}://${this.config.apiUrl}/`;
  }

  private buildUri(uriTemplate: string, urlParams: any): string {
    let uri = uriTemplates(uriTemplate).fill(urlParams);

    // remove trailing slashes
    if (uri.lastIndexOf('/') == uri.length - 1) {
      return uri.substring(0, uri.length - 1);
    }

    return uri;
  }

  get(uriTemplate: string, urlParams: any): Observable<Response> {
    let url = this.apiHost + this.buildUri(uriTemplate, urlParams);
    return this.http.get(url);
  }

  put(uriTemplate: string, urlParams: any, body: any): Observable<Response> {
    let url = this.apiHost + this.buildUri(uriTemplate, urlParams);
    return this.http.put(url, body);
  }

  post(uriTemplate: string, urlParams: any, body: any): Observable<Response> {
    let url = this.apiHost + this.buildUri(uriTemplate, urlParams);
    return this.http.post(url, body, this.headers);
  }

  delete(uriTemplate: string, urlParams: any): Observable<Response> {
    let url = this.apiHost + this.buildUri(uriTemplate, urlParams);
    return this.http.delete(url);
  }

  patch(uriTemplate: string, urlParams: any, body: any): Observable<Response> {
    let url = this.apiHost + this.buildUri(uriTemplate, urlParams);
    return this.http.patch(url, body);
  }

}
