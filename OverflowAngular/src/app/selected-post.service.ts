import { Injectable } from '@angular/core';
import { Post } from './models/post';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SelectedPostService {

  private post = new Post();
  private otherUserPost = new BehaviorSubject<Post>(this.post);
  cast = this.otherUserPost.asObservable();

  getOtherUserPost(otherPost) {
    this.otherUserPost.next(otherPost);
  }

  constructor() { }
}
