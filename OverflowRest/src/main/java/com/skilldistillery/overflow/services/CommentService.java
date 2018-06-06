package com.skilldistillery.overflow.services;

import java.util.List;

import com.skilldistillery.overflow.entities.Comment;
import com.skilldistillery.overflow.entities.CommentVote;
import com.skilldistillery.overflow.entities.User;

public interface CommentService {
	
	List<Comment> getAllComments(int postId);
	
	Comment findCommentByPostId(int postId, int commentId);
	
	Comment createCommentByLoggedInUser(int postId, Comment comment, String username);
	
	Comment updateCommentByLoggedInUser(int postId, Comment comment, String username, int commentId);
	
	boolean destroyCommentByLoggedInUser(int postId, int commentId, String username);

	List<Comment> getCommentsByUserId(int userId);
	
	public CommentVote createVote(int commentId, String username, Boolean vote);
	
	public CommentVote updateVote(int commentId, String username, Boolean vote);

}
