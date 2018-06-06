import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  // END OF FIELDS

   logout = function() {
    this.authService.logout();
    if (!this.authService.checkLogin()) {
      this.router.navigateByUrl('login');
    }
  };

  loggedIn() {
    if (this.authService.checkLogin()) {
      return true;
    }
    return false;
  }

  // END OF METHODS

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }
  ngOnInit() {
  }

}
