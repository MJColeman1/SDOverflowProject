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
	public List<Comment> index(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment show(int commentId, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment create(Comment comment, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment update(int commentId, Comment comment, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean destroy(int commentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
