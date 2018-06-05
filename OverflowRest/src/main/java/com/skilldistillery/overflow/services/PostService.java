package com.skilldistillery.overflow.services;

import java.util.List;

import com.skilldistillery.overflow.entities.Post;

public interface PostService {

	List<Post> getAllPosts();
	
	Post findPostsByPostId(int postId);
	
	Post createPostByLoggedInUser(Post post, int categoryId, int userId, String username);
	
	Post updatePostByLoggedInUser(int postId, int categoryId, int userId, Post post, String username);
	
	Boolean destroyPostByLoggedInUser(int postId, int categoryId, int userId, String username);
	
	List<Post> findByName(String name);
	
}
