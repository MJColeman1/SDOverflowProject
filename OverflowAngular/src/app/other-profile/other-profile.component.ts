import { OtherUserService } from './../other-user.service';
import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';

@Component({
  selector: 'app-other-profile',
  templateUrl: './other-profile.component.html',
  styleUrls: ['./other-profile.component.css']
})
export class OtherProfileComponent implements OnInit {
  otherUser = new User();

  passOtherUserInfo = function() {
     this.OtherUserService.getOtherUserInfo().subscribe(
      data => this.otherUser = data,
      err => console.log(err),
    );
  };

  constructor(
    private otherUserService: OtherUserService
    ) { }

  ngOnInit() {
    // this.usersService.cast.subscribe(user=> this.user = user);
    this.otherUserService.cast.subscribe(data => this.otherUser = data);
  }

}
