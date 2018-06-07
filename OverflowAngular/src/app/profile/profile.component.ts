import { Component, OnInit } from '@angular/core';
import { ProfileService } from '../profile.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Profile } from '../models/profile';
import { User } from '../models/user';
import { Post } from '../models/post';


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

  // GETS OTHER USER INFO FROM POST
  passOtherUserInfo = function() {
    this.OtherUserService.getOtherUserInfo().subscribe(
      data => (this.otherUser = data),
      err => console.log(err)
    );
  };

  // GOES BACK TO LIST OF POSTS
  backToPost = function() {
    this.router.navigateByUrl('/posts');
  };

  // GETS ALL THE POSTS BY THE OTHER USER
  reload = function() {
    console.log(this.otherUser.id);
    this.postService
      .indexOfPostsByOtherUser(this.otherUser.id)
      .subscribe(data => (this.posts = data), err => console.error(err));
  };

  // SHOWS THE POST FROM OTHER USER
  showPost = function(post) {
    this.postService.getPostByOtherUser(this.otherUser.id, post.id).subscribe(
      data => {
        this.post = data;
        console.log(this.post);
      },
      err => console.error(err)
    );
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

  constructor(private profileService: ProfileService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.getProfileForLoggedInUser();
  }

}

