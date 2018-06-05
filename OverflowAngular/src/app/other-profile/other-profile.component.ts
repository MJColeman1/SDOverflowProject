import { Profile } from './../models/profile';
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
  otherUser = new Profile();
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

  };

  constructor(
    private otherUserService: OtherUserService
    ) { }

  ngOnInit() {
    this.otherUserService.cast.subscribe(data => this.otherUser = data);
  }

}
