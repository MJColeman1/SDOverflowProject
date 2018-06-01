import { PostService } from './../post.service';
import { Post } from './../post';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  posts = [];

  post = new Post();

  categories = [];

  selected = null;

  reload = function() {
    this.postService.index().subscribe(
      data => this.posts = data,
      err => console.error('Observer got an error: ' + err)
    );
  };

  displayPost = function(post) {
    console.log(post);
    this.selected = post;
  };

  displayCategories = function() {
    this.postService.getCategories().subscribe(
      data => this.categories = data,
      err => console.error('Category got an error: ' + err)
    );
  };

  return = function() {
    this.selected = null;
  };

  constructor(private postService: PostService) { }

  ngOnInit() {
    this.reload();
    this.displayCategories();
  }

}
