import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { User } from './models/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  user: User = new User();

  login(username, password) {
    // Make token
    console.log('*********** in login *************');
    const token = this.generateBasicAuthToken(username, password);
    // Send token as Authorization header (this is spring security convention for basic auth)
    const headers = new HttpHeaders()
      .set('Authorization', `Basic ${token}`);
    console.log(token);
    console.log(atob(token));
    // create request to authenticate credentials
    return this.http.get('http://localhost:8080/authenticate', {headers})
      .pipe(
        tap((res) => {
          console.log('*********** in tap *************');
          localStorage.setItem('token' , token);
          return res;
        }),
        catchError((err: any) => {
          console.log('*********** in error *************');
          console.log(err);
          return throwError('KABOOM');
        })
      );
  }

  register(dto) {
    // create request to register a new account
    return this.http.post('http://localhost:8080/register', dto)
    .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('KABOOM');
        })
      );
  }

  logout() {
    localStorage.removeItem('token');
  }

  checkLogin() {
    if (localStorage.getItem('token')) {
      return true;
    }
    return false;
  }

  generateBasicAuthToken(username, password) {
    return btoa(`${username}:${password}`);
  }

  getToken() {
    return localStorage.getItem('token');
  }

  constructor(private http: HttpClient) { }

}
