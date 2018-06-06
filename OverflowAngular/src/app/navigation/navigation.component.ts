import { AuthService } from './../auth.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  // logout = function () {
  //   console.log('logging out');
  // };

  notLoggedIn() {
    if (!this.authService.checkLogin()) {
      return true;
    }
    return false;
  }

  constructor(
    private authService: AuthService
  ) { }

  ngOnInit() {
  }

}
