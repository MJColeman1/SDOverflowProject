package com.skilldistillery.overflow.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.overflow.entities.Post;
import com.skilldistillery.overflow.services.PostService;

@RestController
@RequestMapping(path = "/api")
public class PostController {

	@Autowired
	private PostService postService;

	private String username = "jackson";

	@RequestMapping(path = "/posts", method = RequestMethod.GET)
	public List<Post> index() {
		return postService.getAllPosts();
	}

	@RequestMapping(path = "/posts/{postId}", method = RequestMethod.GET)
	public Post show(@PathVariable int postId) {
		return postService.findPostsByPostId(postId);
	}

	@RequestMapping(path = "/users/{userId}/category/{categoryId}/posts", method = RequestMethod.POST)
	public Post create(@PathVariable int userId, @PathVariable int categoryId, @RequestBody Post post,
			HttpServletResponse res) {
		if (postService.createPostByLoggedInUser(post, categoryId, userId, username) == null) {
			res.setStatus(400);
			return null;
		}

		res.setStatus(201);
		return postService.createPostByLoggedInUser(post, categoryId, userId, username);
	}

	@RequestMapping(path = "/users/{userId}/category/{categoryId}/posts/{postId}", method = RequestMethod.PUT)
	public Post update(@PathVariable int userId, @PathVariable int categoryId, @PathVariable int postId,
			@RequestBody Post post, HttpServletResponse res) {
		if (postService.updatePostByLoggedInUser(postId, categoryId, userId, post, username) == null) {
			res.setStatus(400);
			return null;
		}
		res.setStatus(200);
		return postService.updatePostByLoggedInUser(postId, categoryId, userId, post, username);
	}

	@RequestMapping(path = "/users/{userId}/category/{categoryId}/posts/{postId}", method = RequestMethod.DELETE)
	public Boolean delete(@PathVariable int userId, @PathVariable int categoryId, @PathVariable int postId,
			HttpServletResponse res) {
		if (postService.destroyPostByLoggedInUser(postId, categoryId, userId, username)) {
			res.setStatus(200);
			return true;
		}
		res.setStatus(400);
		return false;
	}

}
