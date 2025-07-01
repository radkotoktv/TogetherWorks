import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {API_ENDPOINT} from  './apiURL';
import {Volunteer} from './Volunteer';
import { Observable, of } from 'rxjs';
import {inject} from '@angular/core';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  httpOptions = {
   headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  router : Router = inject(Router);

  constructor(private http: HttpClient) { }
  register(u: Volunteer): Observable<any>{
	 return this.http.post(API_ENDPOINT+'/volunteers/create',u,this.httpOptions);
  }
  login(m: any) :Observable<any> {
	 
	  return this.http.post(API_ENDPOINT+'/volunteers/verify',m,this.httpOptions);
  }
  authenticate() : boolean {
	  if(sessionStorage.getItem('flag')){
		  return true;
	  }
	  return false;
  }
  goToIndex() : void {
	  this.router.navigate(['/index']);
  }
  goToLogin() : void {
	  this.router.navigate(['/login']);
  }
  
  
}
