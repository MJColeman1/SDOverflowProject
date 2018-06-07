import { Component, OnInit } from '@angular/core';
import { ProfileService } from '../profile.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Profile } from '../models/profile';
import { User } from '../models/user';
import { Post } from '../models/post';
import { Employer } from '../models/employer';
import { EmployerService } from '../employer.service';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  users = [];

  profiles = [];

  profile = new Profile;

  updateForm = null;

  employed = null;

  user = new User();

  posts: Post[] = [];

  selected: Post = new Post();

  employers: Employer[] = [];

  // GOES BACK TO LIST OF POSTS
  backToPost = function() {
    this.router.navigateByUrl('/posts');
  };

  // GET PROFILE FOR A LOGGED IN USER
  getProfileForLoggedInUser = function() {
    this.profileService.getProfileAndUser().subscribe(
      data => {
        this.user = data;
        console.log(this.user);
        this.router.navigateByUrl('profile');
      },
      err => console.error(err)
    );
  };

  // UPDATE A USER'S PROFILE
  updateProfile = function(profile) {
    this.profileService.update(profile).subscribe(
      data => {
      this.router.navigateByUrl('profile');

      },
      err => console.log(err)
    );
  };

  // POPULATE THE EMPLOYER SELECT LIST
  populateSelectList = function() {
    this.employerService.index().subscribe(
      data => {
        this.employers = data;
      },
      err => console.log(err)
    );
  };

  constructor(
    private profileService: ProfileService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private employerService: EmployerService
  ) {}

  ngOnInit() {
    this.getProfileForLoggedInUser();
    console.log(this.user.posts);
  }

}

