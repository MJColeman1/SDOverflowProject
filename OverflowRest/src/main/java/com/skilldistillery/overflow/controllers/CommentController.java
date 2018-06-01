package com.skilldistillery.overflow.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.overflow.entities.Comment;
import com.skilldistillery.overflow.services.CommentService;

@RestController
@RequestMapping("api")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(path="posts/{postId}/comments", method = RequestMethod.GET)
	public List<Comment> index(@PathVariable int postId) {
		return commentService.getAllComments(postId);
	}
	
	@RequestMapping(path = "posts/{postId}/comments/{commentId}", method = RequestMethod.GET)
	public Comment show(@PathVariable int postId, @PathVariable int commentId) {
		return commentService.findCommentByPostId(postId, commentId);
	}
	
	@RequestMapping(path = "users/{username}/posts/{postId}/comments", method = RequestMethod.POST)
	public Comment create(@PathVariable int postId, @PathVariable String username, @RequestBody Comment comment) {
		return commentService.createCommentByLoggedInUser(postId, comment, username);
		
	}
	
	@RequestMapping(path = "users/{username}/posts/{postId}/comments/{commentId}", method = RequestMethod.PUT)
	public Comment update(@PathVariable int postId, @PathVariable int commentId, @PathVariable String username, 
			@RequestBody Comment comment) {
		return commentService.updateCommentByLoggedInUser(postId, comment, username, commentId);
	}
	
	@RequestMapping(path = "users/{username}/posts/{postId}/comments/{commentId}", method = RequestMethod.DELETE)
	public Boolean delete(@PathVariable int commentId, @PathVariable int postId, @PathVariable String username) {
		return commentService.destroyCommentByLoggedInUser(postId, commentId, username);
	}

}
