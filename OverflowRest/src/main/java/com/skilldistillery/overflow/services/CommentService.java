package com.skilldistillery.overflow.services;

import java.util.List;

import com.skilldistillery.overflow.entities.Comment;
import com.skilldistillery.overflow.entities.User;

public interface CommentService {
	
	List<Comment> index(User user);
	
	Comment show(int commentId, User user);
	
	Comment create(Comment comment, User user);
	
	Comment update(int commentId, Comment comment, User user);
	
	Boolean destroy(int commentId);

}
