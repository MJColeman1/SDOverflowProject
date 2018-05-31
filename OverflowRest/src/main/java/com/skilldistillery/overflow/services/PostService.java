package com.skilldistillery.overflow.services;

import java.util.List;

import com.skilldistillery.overflow.entities.Post;
import com.skilldistillery.overflow.entities.User;

public interface PostService {

	List<Post> index(User user);
	
	Post show(int postId, User user);
	
	Post create(Post post, User user);
	
	Post update(int postId, Post post, User user);
	
	Boolean destroy(int postId);
	
}
