import { PostService } from './../post.service';
import { Router } from '@angular/router';
import { OtherUserService } from './../other-user.service';
import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { Post } from '../models/post';

@Component({
  selector: 'app-other-profile',
  templateUrl: './other-profile.component.html',
  styleUrls: ['./other-profile.component.css']
})
export class OtherProfileComponent implements OnInit {
  otherUser = new User();
  posts: Post[] = [];
  selected: Post = new Post();

  // GETS OTHER USER INFO FROM POST
  passOtherUserInfo = function() {
    this.OtherUserService.getOtherUserInfo().subscribe(
      data => (this.otherUser = data),
      err => console.log(err)
    );
  };

  // GOES BACK TO LIST OF POSTS
  backToPost = function() {
    this.router.navigateByUrl('/posts');
  };

  // GETS ALL THE POSTS BY THE OTHER USER
  reload = function() {
    console.log(this.otherUser.id);
    this.postService
      .indexOfPostsByOtherUser(this.otherUser.id)
      .subscribe(data => (this.posts = data), err => console.error(err));
  };

  // SHOWS THE POST FROM OTHER USER
  showPost = function(post) {
    this.postService.getPostByOtherUser(this.otherUser.id, post.id).subscribe(
      data => {
        this.post = data;
        console.log(this.post);
      },
      err => console.error(err)
    );
  };

  constructor(
    private postService: PostService,
    private otherUserService: OtherUserService,
    private router: Router
  ) {}

  ngOnInit() {
    this.otherUserService.cast.subscribe(data => (this.otherUser = data));
    this.reload();
  }
}
