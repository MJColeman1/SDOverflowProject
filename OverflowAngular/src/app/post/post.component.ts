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

  comments = [];

  selected = null;

  selectedCategory = null;

  catSelected = false;

  selectedCategoryCount = 0;

  selectedCategoryId = null;

  postsByCategory = [];

  numPostsByCategory = {
    name: '',
    num: '',
  };

  newTopic = false;

  // GET ALL POSTS
  reload = function() {
    this.postService.index().subscribe(
      data => this.posts = data,
      err => console.error('Observer got an error: ' + err)
    );
  };

  // DISPLAY ALL COMMENTS FOR A SPECIFIC POST
  displayCommentsByPost = function(postId) {
    console.log('made it here yay');
    this.postService.getCommentsByPost(postId).subscribe(
      data => this.comments = data,
      err => console.error('Post Comments got an error: ' + err)
    );
  };

  // CREATE A NEW POST (TOPIC)
  createPost = function() {
    console.log(this.post);
    this.postService.createPost(1, this.selectedCategoryId, this.post).subscribe(
      data => this.reload(),
      err => console.error('Create got an error: ' + err)
    );
  };

  displayPost = function(post) {
    console.log(this.posts);
    this.selected = post;
    this.displayCommentsByPost(post.id);
  };

  displayAllPost = function() {
    this.selected = null;
    this.catSelected = false;
    this.selectedCategory = null;
    this.selectedCategoryCount = 0;
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
        this.selectedCategoryCount += 1;
      }
    }
    this.selectedCategory = this.postsByCategory[0].category.name;
    this.catSelected = true;
  };

  startNewTopic = function() {
    this.newTopic = true;
    this.displayCategories();
  };

  // SETS SELECTED TO NULL IN ORDER TO RETURN TO THE MAIN PAGE
  return = function() {
    this.selected = null;
  };

  constructor(private postService: PostService) { }

  ngOnInit() {
    this.reload();
    this.displayCategories();
  }

}
