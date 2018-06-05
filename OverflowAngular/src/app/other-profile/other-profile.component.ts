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

  passOtherUserInfo = function() {
     this.OtherUserService.getOtherUserInfo().subscribe(
      data => this.otherUser = data,
      err => console.log(err),
    );
  };

  showPost = function(post) {

  };

  backToPost = function() {
    this.router.navigateByUrl('/posts');

  };

  constructor(
    private otherUserService: OtherUserService,
    private router: Router
    ) { }

  ngOnInit() {
    this.otherUserService.cast.subscribe(data => this.otherUser = data);
  }

}
