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
	public List<Post> getAllPosts() {
		return postRepo.findAll();
	}

	@Override
	public Post findPostsByPostId(int postId) {
		return postRepo.findById(postId).get();
	}

	@Override
	public Post createPostByLoggedInUser(Post post, String username) {
//		if (!post.getUser().getUsername().equals(username)) {
//			return null;
//		}
		return postRepo.saveAndFlush(post);
	}

	@Override
	public Post updatePostByLoggedInUser(int postId, Post post, String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean destroyPostByLoggedInUser(int postId, String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
