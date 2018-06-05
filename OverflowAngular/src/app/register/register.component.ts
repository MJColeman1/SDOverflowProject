import { AuthService } from './../auth.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../models/user';
import { Profile } from '../models/profile';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User = new User();

  confirmPassword = '';

  // END OF FIELDS

  register = function(user, confirmPassword) {
    // CHECK IF PASSWORDS MATCH
    if (user.password === confirmPassword) {
      console.log(user);
      // IF THEY MATCH SUBSCRIBE AND CALL THE SERVICE REGISTER METHOD
      this.authService.register(user).subscribe(
        // NAVIGATE BACK TO POSTS
        data => this.router.navigateByUrl('posts'),
        // OR LOG THE ERROR
        err => console.log(err)
      );
    }
  };

  // END OF METHODS

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit() {
  }

}
