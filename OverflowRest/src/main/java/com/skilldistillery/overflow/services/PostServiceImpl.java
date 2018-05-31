package com.skilldistillery.overflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.overflow.entities.Post;
import com.skilldistillery.overflow.entities.User;
import com.skilldistillery.overflow.respositories.PostRepository;
import com.skilldistillery.overflow.respositories.UserRepository;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepository postRepo;

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<Post> index(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post show(int postId, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post create(Post post, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post update(int postId, Post post, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean destroy(int postId) {
		// TODO Auto-generated method stub
		return null;
	}

}
