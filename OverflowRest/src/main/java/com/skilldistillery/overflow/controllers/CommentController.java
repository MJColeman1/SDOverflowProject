package com.skilldistillery.overflow.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.overflow.entities.Comment;
import com.skilldistillery.overflow.entities.User;
import com.skilldistillery.overflow.services.CommentService;

public class CommentController {
	@Autowired
	private CommentService commentService;
	
	private String username = "";
	
	@RequestMapping(path = "/posts/{postId}/comments", method = RequestMethod.GET)
	public List<Comment> index(@PathVariable int postId) {
		return commentService.getAllComments();
	}
	
	@RequestMapping(path = "posts/{postId}/comments/{commentId}", method = RequestMethod.GET)
	public Comment show(@PathVariable int postId, @PathVariable int commentId) {
		return commentService.findCommentById(commentId);
	}
	
	@RequestMapping(path = "/comments", method = RequestMethod.POST)
	public Comment create(User user, @RequestBody Comment comment) {
		return commentService.createCommentByLoggedInUser(comment, username);
	}
	
	@RequestMapping(path = "/comments/{commentId}", method = RequestMethod.PUT)
	public Comment update(@PathVariable int commentId, User user, @RequestBody Comment comment) {
		return commentService.updateCommentByLoggedInUse(commentId, comment, username);
	}
	
	@RequestMapping(path = "/comments/{commentId}", method = RequestMethod.DELETE)
	public Boolean delete(@PathVariable int commentId) {
		return commentService.destroyCommentByLoggedInUse(commentId, username);
	}

}
