package com.skilldistillery.overflow.services;

import java.util.List;

import com.skilldistillery.overflow.entities.Post;

public interface PostService {

	List<Post> getAllPosts(String username);
	
	List<Post> getAllPostsByOtherUser(int userId, String username);
	
	Post findPostsByPostId(int postId);
	
	Post findPostsByOtherUserIdPostId(int userId, int postId, String username);
	
	Post createPostByLoggedInUser(Post post, int categoryId, String username);
	
	Post updatePostByLoggedInUser(int postId, int categoryId, int userId, Post post, String username);
	
	Boolean destroyPostByLoggedInUser(int postId, int categoryId, int userId, String username);
	
	List<Post> findByName(String name);
	
}
