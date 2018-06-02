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

  selectedCategory = null;

  catSelected = false;

  postsByCategory = [];

  reload = function() {
    this.postService.index().subscribe(
      data => this.posts = data,
      err => console.error('Observer got an error: ' + err)
    );
  };

  displayPost = function(post) {
    console.log(this.posts);
    this.selected = post;
  };

  displayAllPost = function() {
    this.selected = null;
    this.catSelected = false;
    this.selectedCategory = null;
    this.reload();
  };

  displayCategories = function() {
    this.postService.getCategories().subscribe(
      data => this.categories = data,
      err => console.error('Category got an error: ' + err)
    );
  };

  displayPostsByCategory = function(catId) {
    this.postsByCategory = [];
    for (let i = 0; i < this.posts.length; i++) {
      if (this.posts[i].category.id === catId) {
        this.postsByCategory.push(this.posts[i]);
      }
    }
    this.selectedCategory = this.postsByCategory[0].category.name;
    this.catSelected = true;
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
