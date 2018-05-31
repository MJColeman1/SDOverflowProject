package com.skilldistillery.overflow.services;

import java.util.List;

import com.skilldistillery.overflow.entities.Comment;

public interface CommentService {
	
	List<Comment> getAllComments();
	
	Comment findCommentById(int commentId);
	
	Comment createCommentByLoggedInUser(Comment comment, String username);
	
	Comment updateCommentByLoggedInUse(int commentId, Comment comment,String username);
	
	Boolean destroyCommentByLoggedInUse(int commentId, String username);

}
