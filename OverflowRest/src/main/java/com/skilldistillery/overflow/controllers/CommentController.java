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
	
	@RequestMapping(path = "/comments", method = RequestMethod.GET)
	public List<Comment> index(User user) {
		return commentService.index(user);
	}
	
	@RequestMapping(path = "/comments/{commentId}", method = RequestMethod.GET)
	public Comment show(@PathVariable int commentId, User user) {
		return commentService.show(commentId, user);
	}
	
	@RequestMapping(path = "/comments", method = RequestMethod.POST)
	public Comment create(User user, @RequestBody Comment comment) {
		return commentService.create(comment, user);
	}
	
	@RequestMapping(path = "/comments/{commentId}", method = RequestMethod.PUT)
	public Comment update(@PathVariable int commentId, User user, @RequestBody Comment comment) {
		return commentService.update(commentId, comment,  user);
	}
	
	@RequestMapping(path = "/comments/{commentId}", method = RequestMethod.DELETE)
	public Boolean delete(@PathVariable int commentId) {
		return commentService.destroy(commentId);
	}

}
