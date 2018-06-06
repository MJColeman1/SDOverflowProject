import { SelectedPostService } from './../selected-post.service';
import { User } from './../models/user';
import { Router } from '@angular/router';
import { OtherUserService } from './../other-user.service';
import { Category } from './../models/category';
import { Comment } from './../models/comment';
import { PostService } from './../post.service';
import { Component, OnInit } from '@angular/core';
import { Post } from '../models/post';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {
  posts = [];

  post = new Post();

  comment = new Comment();

  category = new Category();

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

  initEdit = false;

  otherUser = new User();

  editedComment = new Comment();

  keyword = null;

  postsByKeyword = [];

  tempPosts = [];

  start = 0;

  end = 4;

  username = '';

  newCatMessage = '';

  // GET ALL POSTS AND NUM OF COMMENTS PER POST
  reload = function() {
    this.numPostsByCategory = {};
    this.postsByCategoryKeys = [];
    this.postService.index().subscribe(
      data => {
        this.posts = data;
        this.tempPosts = data;
        this.calculateNumPostsByCategory(this.posts);
        this.calculateNumCommentsByPost(this.posts);
        this.category = new Category();
        this.post = new Post();
        this.selectedCategoryId = null;
        this.selected = null;
        if (localStorage.getItem('token')) {
          this.username = atob(localStorage.getItem('token')).split(':')[0];
        }
        console.log(this.username);
      },
      err => console.error('Observer got an error: ' + err)
    );
  };

  // ADD A VOTE FOR A COMMENT
  addVote = function(commentId, vote) {
    this.postService.addVote(commentId, vote).subscribe(
      data => this.reload(),
      err => console.error('Vote got an error: ' + err)
    );
  };

  // DISPLAY POSTS BY SEARCH KEYWORD
  displayPostsBySearch = function(keyword) {
    this.postsByKeyword = [];
    this.posts = this.tempPosts;
    console.log(this.posts);
    for (let i = 0; i < this.posts.length; i++) {
      if (this.posts[i].name.includes(keyword)) {
        this.postsByKeyword.push(this.posts[i]);
      }
    }
    this.keyword = null;
    this.posts = this.postsByKeyword;
    this.postsByCategory = this.postsByKeyword; // TESTING
    console.log(this.posts); // TESTING
    this.start = 0;
    this.end = 4;
  };

  // EDIT SELECTED POST (DOES NOT WORK YET)
  editPost = function(post) {
    this.postService
      .updatePost(1, post.category.id, post)
      .subscribe(
        data => this.reload(),
        err => console.error('Update Post got an error: ' + err)
      );
  };

  // DELETE SELECTED POST
  deletePost = function(post) {
    this.postService
      .deletePost(1, post.category.id, post.id)
      .subscribe(
        data => this.reload(),
        err => console.error('Delete Post got an error: ' + err)
      );
  };

  // INITIATE COMMENT EDIT
  initiateEdit = function(id, comment) {
    this.initEdit = id;
    this.editedComment = comment;
  };

  // EDIT COMMENT
  editComment = function(comment) {
    console.log(comment);
    this.postService.updateComment(this.selected.id, comment).subscribe(
      data => {
        this.initEdit = 0;
        // this.reload();
      },
      err => console.error('Update Comment got an error: ' + err)
    );
  };

  // CANCEL EDIT
  cancelEdit = function() {
    this.initEdit = 0;
  };

  // DELETE COMMENT
  deleteComment = function(comment) {
    this.postService.deleteComment(this.selected.id, comment.id).subscribe(
      data => {
        this.initEdit = 0;
        this.displayPost(this.selected);
      },
      err => console.error('Delete Comment got an error: ' + err)
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
    this.postService
      .getCommentsByPost(postId)
      .subscribe(
        data => (this.comments = data),
        err => console.error('Post Comments got an error: ' + err)
      );
  };

  // CREATE A NEW POST (TOPIC)
  createPost = function() {
    if (this.post.name && this.post.description) {
      this.postService
        .createPost(this.selectedCategoryId, this.post)
        .subscribe(
          data => {
            this.reload();
            this.newTopic = false;
          },
          err => console.error('Create got an error: ' + err)
        );
    }
  };

  // CREATE A NEW COMMENT FOR A POST
  createComment = function() {
    console.log(this.comment);
    this.postService.createComment(this.selected.id, this.comment).subscribe(
      data => {
        this.displayCommentsByPost(this.selected.id);
        this.comment = new Comment();
      },
      err => console.error('Create Comment got an error: ' + err)
    );
  };

  // CREATE A NEW CATEGORY FROM NEW TOPIC PAGE
  createCategory = function() {
    console.log(this.categories);
    if (this.category.name) {
      let catExist = false;
      for (let i = 0; i < this.categories.length; i++) {
        if (this.categories[i].name === this.category.name) {
          catExist = true;
          this.newCatMessage =
            '(' +
            this.category.name +
            ' Already Exists: Click Cancel or Enter New Category)';
          break;
        }
      }
      if (!catExist) {
        this.postService.createCategory(1, this.category).subscribe(
          data => {
            console.log(data.id);
            this.selectedCategoryId = data.id;
            this.displayCategories();
          },
          err => console.error('Create Category got an error: ' + err)
        );
      }
    }
  };

  // DISPLAY SELECTED POST AND COMMENTS
  displayPost = function(post) {
    // if (!post) {
    //   this.selectedService.cast.subscribe(data => (this.selected = data));
    // }
    this.selected = post;
    this.displayCommentsByPost(post.id);
  };

  // FUNCTION TO DISPLAY ALL POSTS AGAIN
  displayAllPost = function() {
    this.selected = null;
    this.catSelected = false;
    this.selectedCategory = null;
    this.selectedCategoryCount = 0;
    this.start = 0;
    this.end = 4;
    this.reload();
  };

  // OBTAIN ALL THE CATEGORIES OF POSTS
  displayCategories = function() {
    this.postService
      .getCategories()
      .subscribe(
        data => (this.categories = data),
        err => console.error('Category got an error: ' + err)
      );
  };

  // DISPLAY ALL POSTS BY SELECTED CATEGORY
  displayPostsByCategory = function(catId) {
    this.postsByCategory = [];
    this.posts = this.tempPosts;
    // console.log(this.posts);
    for (let i = 0; i < this.posts.length; i++) {
      if (this.posts[i].category.id === catId) {
        this.postsByCategory.push(this.posts[i]);
        this.selectedCategoryCount += 1;
      }
    }
    this.start = 0;
    this.end = 4;
    this.selectedCategory = this.postsByCategory[0].category.name;
    this.catSelected = true;
    this.newTopic = false;
  };

  startNewTopic = function() {
    this.newTopic = true;
    this.displayCategories();
  };

  // SETS SELECTED TO NULL IN ORDER TO RETURN TO THE MAIN PAGE
  return = function() {
    this.selected = null;
  };

  // PASSES OTHER USER INFORMATION TO SERIVCE
  passOtherUserInfo = function(otherUserInfo) {
    this.otherUserService.getOtherUserInfo(otherUserInfo);
    this.router.navigateByUrl('/otherUser');
  };

  // DISPLAY NEXT 4 POSTS
  pagRight = function() {
    if (this.end < this.posts.length - 1) {
      this.start += 4;
      this.end += 4;
    }
  };

  // DISPLAY NEXT 4 POSTS BY CATEGORY
  pagRightCat = function() {
    if (this.end < this.postsByCategory.length - 1) {
      this.start += 4;
      this.end += 4;
    }
  };

  // DISPLAY PREVIOUS 4 POSTS
  pagLeft = function() {
    if (this.start >= 4) {
      this.start -= 4;
      this.end -= 4;
    }
  };

  constructor(
    private postService: PostService,
    private otherUserService: OtherUserService,
    private selectedService: SelectedPostService,
    private router: Router
  ) {}

  ngOnInit() {
    this.reload();
    // this.selectedService.cast.subscribe(data => (this.selected = data));
    this.displayCategories();
    this.otherUserService.cast.subscribe(
      data => (this.otherUser = data),
      err => console.error(err)
    );
  }
}
