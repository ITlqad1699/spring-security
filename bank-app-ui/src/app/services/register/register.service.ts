import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { User } from "src/app/model/user.model";
import { Observable, Subject } from 'rxjs';
import { AppConstants } from 'src/app/constants/app.constants';
import { environment } from '../../../environments/environment';
import { Register } from 'src/app/model/register.model';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http:HttpClient) { }

  validateUser() {
  }

  regisUser(register : Register){

    return this.http.post(environment.rooturl + AppConstants.REGISTER_API_URL,register,{ observe: 'response'});
  }

 
}
