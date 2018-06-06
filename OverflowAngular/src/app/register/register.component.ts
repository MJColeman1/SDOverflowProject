import { AuthService } from './../auth.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Profile } from '../models/profile';
import { Userdto } from '../models/userdto';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  dto: Userdto = new Userdto();

  confirmPassword = '';

  // END OF FIELDS

  register = function(dto, confirmPassword) {
    // CHECK IF PASSWORDS MATCH
    if (dto.userPassword === confirmPassword) {
      console.log(dto);
      // IF THEY MATCH SUBSCRIBE AND CALL THE SERVICE REGISTER METHOD
      this.authService.register(dto).subscribe(
        // NAVIGATE BACK TO POSTS
        data => {
          console.log(dto.userUsername);
          console.log(dto.userPassword);
          this.router.navigateByUrl('posts');
        },
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
