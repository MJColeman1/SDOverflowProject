import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { Profile } from '../models/profile';
import { UserService } from '../user.service';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  users = [];

  user = new User();

  profiles = [];

  profile = new Profile();

  constructor(private userService: UserService) { }

  ngOnInit() {
  }
// user will create start of profile as part of the new user created done in html
  createUser = function() {
    this.userService.createUser(this.user).subscribe(
      data => {

      },
      err => console.error('CreateUser got an error: ' + err)
    );
  };
}
