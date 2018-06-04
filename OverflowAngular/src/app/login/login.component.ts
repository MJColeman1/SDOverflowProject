import { AuthService } from './../auth.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login = function(user) {
    // Subscribe to authService passing in the form username and password
    this.authService.login(user.username, user.password).subscribe(
      // On success log in and route back to posts
      data => this.router.navigateByUrl('posts'),
      // If error return this instead
      err => console.log(err)
    );
  };

  // END OF METHODS

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit() {
  }

}
