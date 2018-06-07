import { PostService } from './../post.service';
import { Component, OnInit } from '@angular/core';
import { ProfileService } from '../profile.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Profile } from '../models/profile';
import { User } from '../models/user';
import { Post } from '../models/post';
import { Employer } from '../models/employer';
import { EmployerService } from '../employer.service';
import { Address } from '../models/address';
import { NgForm } from '@angular/forms';
import { Profiledto } from '../models/profiledto';


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

  address = new Address();

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
        if (data.profile.address == null) {
          data.profile.address = new Address();
        }
        if (data.profile.employer == null) {
          data.profile.employer = new Employer();
        }
        if (data.profile.employer.address == null) {
          data.profile.employer.address = new Address();
        }
        this.user = data;
        this.populateUserPosts(this.user.id);
        // console.log(this.user);
        this.router.navigateByUrl('profile');
      },
      err => console.error(err)
    );
  };

  // UPDATE A USER'S PROFILE
  updateProfile = function(form: NgForm) {
    const dto = new Profiledto();
    dto.profileFirstName = form.value.profileFirstName;
    dto.profileLastName = form.value.profileLastName;
    dto.profileEmail = form.value.profileEmail;
    dto.profileCohort = form.value.profileCohort;
    dto.addressStreet = form.value.addressStreet;
    dto.addressStreet2 = form.value.addressStreet2;
    dto.addressCity = form.value.addressCity;
    dto.addressState = form.value.addressState;
    dto.addressCountry = form.value.addressCountry;
    dto.addressZip = form.value.addressZip;
    dto.employerName = form.value.employerName;
    dto.employerAddressStreet = form.value.employerAddressStreet;
    dto.employerAddressStreet2 = form.value.employerAddressStreet2;
    dto.employerAddressCity = form.value.employerAddressCity;
    dto.employerAddressState = form.value.employerAddressState;
    dto.employerAddressCountry = form.value.employerAddressCountry;
    dto.employerAddressZip = form.value.employerAddressZip;
    // console.log(dto);
    this.profileService.updateProfile(dto).subscribe(
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

  populateUserPosts = function(userId) {
    this.postService
      .indexOfPostsByOtherUser(userId)
      .subscribe(
        data => (this.posts = data),
        err => console.error(err));
  };

  constructor(
    private profileService: ProfileService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private employerService: EmployerService,
    private postService: PostService
  ) {}

  ngOnInit() {
    this.getProfileForLoggedInUser();
    this.populateSelectList();
    // console.log(this.user.posts);
  }

}

