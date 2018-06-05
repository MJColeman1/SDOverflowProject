import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Post } from './models/post';
import { Category } from './models/category';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private url = 'http://localhost:8080/api/posts/';
  private categoryUrl = 'http://localhost:8080/api/categories';
  private createUrl = 'http://localhost:8080/api/users/';
  private catUrl = 'http://localhost:8080/api/user/';
  private deleteUrl = 'http://localhost:8080/api/users/';
  private updateUrl = 'http://localhost:8080/api/users/';

  index() {
    return this.http.get<Post[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Index Error');
      })
    );
  }

  getCommentsByPost(postId) {
    return this.http.get<Post[]>(this.url + postId + '/comments/').pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Comments Post Error');
      })
    );
  }

  createPost(userId, catId, post) {
    return this.http.post(this.createUrl + userId + '/category/' + catId + '/posts', post).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Create Error');
      })
    );
  }

  createComment(pId, comment) {
    return this.http.post(this.url + pId + '/comments', comment).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Create Error');
      })
    );
  }

  createCategory(userId, category) {
    return this.http.post(this.catUrl + userId + '/categories', category).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Create Category Error');
      })
    );
  }

  getCategories() {
    return this.http.get<Category[]>(this.categoryUrl).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Category Error');
      })
    );
  }

  deletePost(userId, catId, postId) {
    return this.http.delete(this.deleteUrl + userId + '/category/' + catId + '/posts/' + postId).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Delete Error');
      })
    );
  }

  updatePost(userId, catId, post) {
    return this.http.put(this.updateUrl + userId + '/category/' + catId + '/posts/' + post.id, post).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Update Error');
      })
    );
  }

  updateComment(postId, comment) {
    return this.http.put(this.url + postId + '/comments/' + comment.id, comment).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Update Commment Error');
      })
    );
  }

  deleteComment(postId, commentId) {
    return this.http.delete(this.url + postId + '/comments/' + commentId).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Delete Comment Error');
      })
    );
  }

  constructor(private http: HttpClient) { }
}
