import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { Profile } from '../models/profile';
import { UserService } from '../user.service';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  users = [];

  confirmPassword = '';

  user = new User();


  constructor(private userService: UserService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
  }

  updateUser = function(user, confirmPassword) {
    if (user.password === confirmPassword) {
    this.userService.update(user).subscribe(
      data => {
      this.router.navigateByUrl('profile');

      },
      err => console.log(err)
    );
  }

  };







}
