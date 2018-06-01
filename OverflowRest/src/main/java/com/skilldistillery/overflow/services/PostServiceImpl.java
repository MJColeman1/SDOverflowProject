package com.skilldistillery.overflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.overflow.entities.Category;
import com.skilldistillery.overflow.entities.Post;
import com.skilldistillery.overflow.entities.User;
import com.skilldistillery.overflow.respositories.CategoryRepository;
import com.skilldistillery.overflow.respositories.PostRepository;
import com.skilldistillery.overflow.respositories.UserRepository;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepository postRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public List<Post> getAllPosts() {
		return postRepo.findAll();
	}

	@Override
	public Post findPostsByPostId(int postId) {
		return postRepo.findById(postId).get();
	}

	@Override
	public Post createPostByLoggedInUser(Post post, int categoryId, int userId, String username) {
		User user = userRepo.findById(userId).get();
		post.setUser(user);

		Category category = categoryRepo.findById(categoryId).get();
		post.setCategory(category);

		if (user.getUsername().equals(username)) {
			return postRepo.saveAndFlush(post);
		}
		return null;

	}

	@Override
	public Post updatePostByLoggedInUser(int postId, int categoryId, int userId, Post post, String username) {
		Post managed = postRepo.findById(postId).get();
		Category category = categoryRepo.findById(categoryId).get();

		if (managed.getUser().getUsername().equals(username)) {
			if (managed.getCategory() == category) {

				managed.setName(post.getName());
				managed.setDescription(post.getDescription());

				return postRepo.saveAndFlush(managed);
			}

		}

		return null;
	}

	@Override
	public Boolean destroyPostByLoggedInUser(int postId, int categoryId, int userId, String username) {
		Category category = categoryRepo.findById(categoryId).get();
		Post post = postRepo.findById(postId).get();

		boolean deleted = false;

		try {
			if (post.getUser().getUsername().equals(username)) {
				if (post.getCategory() == category) {

					postRepo.deleteById(postId);
					deleted = true;
					return deleted;

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleted;
	}

}
