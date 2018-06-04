import { Injectable } from '@angular/core';
import { shallowEqual } from '@angular/router/src/utils/collection';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { User } from './models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private url = 'http://localhost:8080/api/users/';
  constructor(private http: HttpClient) { }


index() {
  return this.http.get<User[]>(this.url).pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError('Index Error');
    })
  );
}



createUser (user) {
  return this.http.post(this.url, user).pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError('Create Error');
    })
  );
}


// are we searching by username? show()

}
