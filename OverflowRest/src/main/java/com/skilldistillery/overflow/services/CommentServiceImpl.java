package com.skilldistillery.overflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.overflow.entities.Comment;
import com.skilldistillery.overflow.entities.User;
import com.skilldistillery.overflow.respositories.CommentRepository;
import com.skilldistillery.overflow.respositories.UserRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepo;
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<Comment> getAllComments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment findCommentById(int commentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment createCommentByLoggedInUser(Comment comment, String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment updateCommentByLoggedInUse(int commentId, Comment comment, String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean destroyCommentByLoggedInUse(int commentId, String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
}