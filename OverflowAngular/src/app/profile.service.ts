import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { AuthService } from './auth.service';
import { Profile } from './models/profile';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  private url = 'http://localhost:8080/api/profile';
  constructor(private http: HttpClient, private router: Router, private authService: AuthService) { }




 updateProfile( profile: Profile) {
  const token = this.authService.getToken();
    const headers = new HttpHeaders()
    .set('Authorization', `Basic ${token}`);
    if (!this.authService.checkLogin()) {
      this.router.navigateByUrl('login');

    }

    return this.http.put<Profile>(this.url + '/' + profile.id, profile, {headers})
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('updateProfile Error');

      })
    );
  }
}
