import { AuthService } from './auth.service';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Post } from './models/post';
import { Category } from './models/category';
import { ActivatedRoute, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private baseUrl = 'http://localhost:8080';
  private url = this.baseUrl + '/api/posts/';
  private categoryUrl = 'http://localhost:8080/api/categories';
  private createUrl = 'http://localhost:8080/api/users/';
  private catUrl = 'http://localhost:8080/api/user/';
  private deleteUrl = 'http://localhost:8080/api/users/';
  private updateUrl = 'http://localhost:8080/api/users/';

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
    return this.http.get<Post[]>(this.url, {headers}).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Index Error');
      })
    );
  }

  indexOfPostsByOtherUser(userId: number) {
    console.log(userId);
    return this.http.get<Post[]>(this.baseUrl + '/api/user/' + userId + '/posts').pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Index Other User Posts Error');
      })
    );
  }

  getPostByOtherUser(userId: number, postId: number) {
    console.log(userId);
    return this.http.get<Post>(this.baseUrl + '/api/user/' + userId + '/posts/' + postId).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Index Other User Posts Error');
      })
    );
  }

  getCommentsByPost(postId) {
    if (!this.authService.checkLogin()) {
      this.router.navigateByUrl('login');
    }

    const headers = this.getToken();
    return this.http.get<Post[]>(this.url + postId + '/comments/', {headers}).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Comments Post Error');
      })
    );
  }

  createPost(userId, catId, post) {
    if (!this.authService.checkLogin()) {
      this.router.navigateByUrl('login');
    }

    const headers = this.getToken();
    return this.http.post(this.createUrl + userId + '/category/' + catId + '/posts', post, {headers}).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Create Error');
      })
    );
  }

  createComment(pId, comment) {
    if (!this.authService.checkLogin()) {
      this.router.navigateByUrl('login');
    }

    const headers = this.getToken();
    return this.http.post(this.url + pId + '/comments', comment, {headers}).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Create Error');
      })
    );
  }

  createCategory(userId, category) {
    if (!this.authService.checkLogin()) {
      this.router.navigateByUrl('login');
    }

    const headers = this.getToken();
    return this.http.post(this.catUrl + userId + '/categories', category, {headers}).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Create Category Error');
      })
    );
  }

  getCategories() {
    if (!this.authService.checkLogin()) {
      this.router.navigateByUrl('login');
    }

    const headers = this.getToken();

    return this.http.get<Category[]>(this.categoryUrl, {headers}).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Category Error');
      })
    );
  }

  deletePost(userId, catId, postId) {
    if (!this.authService.checkLogin()) {
      this.router.navigateByUrl('login');
    }

    const headers = this.getToken();
    return this.http.delete(this.deleteUrl + userId + '/category/' + catId + '/posts/' + postId, {headers}).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Delete Error');
      })
    );
  }

  updatePost(userId, catId, post) {
    if (!this.authService.checkLogin()) {
      this.router.navigateByUrl('login');
    }

    const headers = this.getToken();
    return this.http.put(this.updateUrl + userId + '/category/' + catId + '/posts/' + post.id, post, {headers}).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Update Error');
      })
    );
  }

  updateComment(postId, comment) {
    if (!this.authService.checkLogin()) {
      this.router.navigateByUrl('login');
    }

    const headers = this.getToken();
    return this.http.put(this.url + postId + '/comments/' + comment.id, comment, {headers}).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Update Commment Error');
      })
    );
  }

  deleteComment(postId, commentId) {
    if (!this.authService.checkLogin()) {
      this.router.navigateByUrl('login');
    }

    const headers = this.getToken();
    return this.http.delete(this.url + postId + '/comments/' + commentId, {headers}).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Delete Comment Error');
      })
    );
  }

  constructor(private http: HttpClient, private authService: AuthService, private router: Router) { }
}
