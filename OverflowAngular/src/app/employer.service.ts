import { AuthService } from './auth.service';
import { Injectable } from '@angular/core';
import { Employer } from './models/employer';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class EmployerService {

  // SERVICE FIELDS
  private baseUrl = 'http://localhost:8080/';
  private url = this.baseUrl + 'api/employers/';

  // SERVICE METHODS
  getToken() {
    const token = this.authService.getToken();
    const headers = new HttpHeaders()
      .set('Authorization', `Basic ${token}`);
    return headers;
  }

  index() {
    if (!this.authService.checkLogin()) {
      this.router.navigateByUrl('login');
    }

    const headers = this.getToken();
    return this.http.get<Employer[]>(this.url, {headers})
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('Index Error');
        })
      );
  }

  show(employerId: number) {
    if (!this.authService.checkLogin()) {
      this.router.navigateByUrl('login');
    }

    const headers = this.getToken();
    return this.http.get<Employer>(this.url + employerId, {headers})
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('Index Error');
        })
      );
  }

  constructor(
    private http: HttpClient,
    private authService: AuthService,
    private router: Router
  ) {}
}
