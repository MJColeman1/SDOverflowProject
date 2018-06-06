import { Component, OnInit } from '@angular/core';
import { ProfileService } from '../profile.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Profile } from '../models/profile';
import { User } from '../models/user';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  users = [];

  profiles = [];

  profile = new Profile;

  posts = [];

  user = new User();

  constructor(private profileService: ProfileService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
  }


  updateProfile = function(user,  profile) {
    this.profileService.update(profile).subscribe(
      data => {
      this.router.navigateByUrl('profile');

      },
      err => console.log(err)
    );
  };
  displayPost = function(post) {
    this.selected = post;
    this.displayCommentsByPost(post.id);
  };

  showPost = function(post) {

  };

  backToPost = function() {

  };
}


