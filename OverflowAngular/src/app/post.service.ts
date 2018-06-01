import { Post } from './post';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private url = 'http://localhost:8080/api/posts/';

  index() {
    return this.http.get<Post[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Index Error');
      })
    );
  }

  constructor(private http: HttpClient) { }
}
