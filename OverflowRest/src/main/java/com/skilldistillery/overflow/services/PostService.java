package com.skilldistillery.overflow.services;

import java.util.List;

import com.skilldistillery.overflow.entities.Post;

public interface PostService {

	List<Post> getAllPosts();
	
	Post findPostsByPostId(int postId);
	
	Post createPostByLoggedInUser(Post post, String username);
	
	Post updatePostByLoggedInUser(int postId, Post post, String username);
	
	Boolean destroyPostByLoggedInUser(int postId, String username);
	
}