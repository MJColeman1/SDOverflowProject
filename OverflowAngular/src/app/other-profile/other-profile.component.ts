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

  };

  constructor(
    private otherUserService: OtherUserService
    ) { }

  ngOnInit() {
  }

}
