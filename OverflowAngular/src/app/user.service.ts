import { environment } from './../environments/environment.prod';
import { Injectable } from '@angular/core';
import { shallowEqual } from '@angular/router/src/utils/collection';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { User } from './models/user';
import { Router } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  // URL
  // private baseUrl = 'http://localhost:8080/';
  private baseUrl = environment.baseUrl;
  private url = this.baseUrl + 'api/users/';

  constructor(
    private http: HttpClient,
    private router: Router,
    private authService: AuthService
  ) {}

  index() {
    const token = this.authService.getToken();
    const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);

    return this.http.get<User[]>(this.url)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('updateUser Error');
        })
      );

  }

  updateUser(user: User) {
    const token = this.authService.getToken();
    const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);
    if (!this.authService.checkLogin()) {
      this.router.navigateByUrl('login');
    }

    return this.http
      .put<User>(this.url + '/' + user.id, user, { headers })
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('updateUser Error');
        })
      );
  }
}
