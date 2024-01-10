import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './../models/user';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RegistrationServiceService {

  constructor(private _http : HttpClient) { }

  public register(user :User):Observable<any>{
    
   console.log(user);
    return this._http.post("http://localhost:9090/v1/user/add",user, {responseType: 'text' as 'json' });
  }
}
