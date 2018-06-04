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

  numPostsByCategory = {};

  postsByCategoryKeys = [];

  numCommentsByPost = {};

  commentsByPostKeys = [];

  newTopic = false;

  // GET ALL POSTS AND NUM OF COMMENTS PER POST
  reload = function() {
    this.numPostsByCategory = {};
    this.postsByCategoryKeys = [];
    this.postService.index().subscribe(
      data => {
        this.posts = data;
        this.calculateNumPostsByCategory(this.posts);
        this.calculateNumCommentsByPost(this.posts);
      },
      err => console.error('Observer got an error: ' + err)
    );
  };

  // GET NUMBER OF POSTS FOR EACH POST CATEGORY
  calculateNumPostsByCategory = function(posts) {
    for (let i = 0; i < posts.length; i++) {
      if (isNaN(this.numPostsByCategory[posts[i].category.name])) {
        this.numPostsByCategory[posts[i].category.name] = 1;
      } else {
        this.numPostsByCategory[posts[i].category.name] += 1;
      }
    }
    this.postsByCategoryKeys = Object.keys(this.numPostsByCategory);
  };

  // GET NUMBER OF COMMENTS FOR EACH POST
  calculateNumCommentsByPost = function(posts) {
    for (let j = 0; j < posts.length; j++) {
      let num = 0;
      for (let k = 0; k < posts[j].comments.length; k++) {
        num += 1;
      }
      this.numCommentsByPost[posts[j].name] = num;
    }
    this.commentsByPostKeys = Object.keys(this.numCommentsByPost);
  };

  // DISPLAY ALL COMMENTS FOR A SPECIFIC POST
  displayCommentsByPost = function(postId) {
    this.postService.getCommentsByPost(postId).subscribe(
      data => this.comments = data,
      err => console.error('Post Comments got an error: ' + err)
    );
  };

  // CREATE A NEW POST (TOPIC)
  createPost = function() {
    this.postService.createPost(1, this.selectedCategoryId, this.post).subscribe(
      data => {
        this.reload();
        this.newTopic = false;
      },
      err => console.error('Create got an error: ' + err)
    );
  };

  // DISPLAY SELECTED POST AND COMMENTS
  displayPost = function(post) {
    this.selected = post;
    this.displayCommentsByPost(post.id);
  };

  // FUNCTION TO DISPLAY ALL POSTS AGAIN
  displayAllPost = function() {
    this.selected = null;
    this.catSelected = false;
    this.selectedCategory = null;
    this.selectedCategoryCount = 0;
    this.reload();
  };

  // OBTAIN ALL THE CATEGORIES OF POSTS
  displayCategories = function() {
    this.postService.getCategories().subscribe(
      data => this.categories = data,
      err => console.error('Category got an error: ' + err)
    );
  };

  // DISPLAY ALL POSTS BY SELECTED CATEGORY
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
