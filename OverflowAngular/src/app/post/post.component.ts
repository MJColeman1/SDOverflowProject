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

  constructor(private postService: PostService) { }

  ngOnInit() {
    this.reload();
  }

}
