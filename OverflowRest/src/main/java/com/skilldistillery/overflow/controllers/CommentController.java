package com.skilldistillery.overflow.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.overflow.entities.Comment;
import com.skilldistillery.overflow.entities.CommentVote;
import com.skilldistillery.overflow.services.CommentService;

@RestController
@CrossOrigin({"*", "http://localhost:4200"})
@RequestMapping("api")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	
	@RequestMapping(path="posts/{postId}/comments", method = RequestMethod.GET)
	public List<Comment> index(@PathVariable int postId, HttpServletRequest req, HttpServletResponse res, Principal principal) {
		return commentService.getAllComments(postId);
	}
	
	@RequestMapping(path = "posts/{postId}/comments/{commentId}", method = RequestMethod.GET)
	public Comment show(@PathVariable int postId, @PathVariable int commentId) {
		return commentService.findCommentByPostId(postId, commentId);
	}
	
	@RequestMapping(path = "posts/{postId}/comments", method = RequestMethod.POST)
	public Comment create(@PathVariable int postId, @RequestBody Comment comment, Principal principal) {
		return commentService.createCommentByLoggedInUser(postId, comment, principal.getName());
		
	}
	
	@RequestMapping(path = "posts/{postId}/comments/{commentId}", method = RequestMethod.PUT)
	public Comment update(@PathVariable int postId, @PathVariable int commentId, 
			@RequestBody Comment comment, Principal principal) {
		return commentService.updateCommentByLoggedInUser(postId, comment, principal.getName(), commentId);
	}
	
	@RequestMapping(path = "posts/{postId}/comments/{commentId}", method = RequestMethod.DELETE)
	public Boolean delete(@PathVariable int commentId, @PathVariable int postId, Principal principal) {
		return commentService.destroyCommentByLoggedInUser(postId, commentId, principal.getName());
	}
	
	@RequestMapping(path = "comment/{commentId}/vote", method = RequestMethod.POST)
	public CommentVote createVote(@PathVariable int commentId, Principal principal, @RequestBody String vote) {
		System.out.println(vote);
		return commentService.createVote(commentId, principal.getName(), Boolean.parseBoolean(vote));
	}
	
	@RequestMapping(path = "comment/{commentId}/vote", method = RequestMethod.PUT)
	public CommentVote updateVote(@PathVariable int commentId, Principal principal, @RequestBody String vote) {
		System.out.println(vote);
		return commentService.updateVote(commentId, principal.getName(), Boolean.parseBoolean(vote));
	}

	@RequestMapping(path = "comment/{commentId}/{vote}", method = RequestMethod.GET) 
	public int voteCount(@PathVariable int commentId, @PathVariable String vote) {
		return commentService.voteCount(commentId, Boolean.parseBoolean(vote));
	}
}
