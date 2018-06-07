package com.skilldistillery.overflow.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.overflow.entities.Post;
import com.skilldistillery.overflow.services.PostService;

@RestController
@CrossOrigin({ "*", "http://localhost:4200" })
@RequestMapping(path = "/api")
public class PostController {

	@Autowired
	private PostService postService;

	private String username = "jackson";

	@RequestMapping(path = "/posts", method = RequestMethod.GET)
	public List<Post> index(HttpServletRequest req, HttpServletResponse res, Principal principal) {
		return postService.getAllPosts(principal.getName());
	}

	@RequestMapping(path = "user/{userId}/posts", method = RequestMethod.GET)
	public List<Post> indexOfOtherUserPOsts(@PathVariable int userId, HttpServletResponse res, Principal principal) {
		List<Post> posts = postService.getAllPostsByOtherUser(userId, principal.getName());
		if (posts != null) {
			res.setStatus(200);
			return posts;
		}
		return null;
	}

	@RequestMapping(path = "/posts/{postId}", method = RequestMethod.GET)
	public Post show(@PathVariable int postId) {
		return postService.findPostsByPostId(postId);
	}

	@RequestMapping(path = "user/{userId}/posts/{postId}", method = RequestMethod.GET)
	public Post showPostByOtherUser(@PathVariable int userId, @PathVariable int postId, HttpServletResponse res,
			Principal principal) {
		Post post = postService.findPostsByOtherUserIdPostId(userId, postId, principal.getName());
		if (post != null) {
			res.setStatus(200);
			return post;
		}
		return null;
	}

	@RequestMapping(path = "category/{categoryId}/posts", method = RequestMethod.POST)
	public Post create(@PathVariable int categoryId, @RequestBody Post post,
			HttpServletResponse res, Principal principal) {
		Post createdPost = postService.createPostByLoggedInUser(post, categoryId, principal.getName());
		if (createdPost == null) {
			res.setStatus(400);
			return null;
		}
		res.setStatus(201);
		return createdPost;
	}

	@RequestMapping(path = "/users/{userId}/category/{categoryId}/posts/{postId}", method = RequestMethod.PUT)
	public Post update(@PathVariable int userId, @PathVariable int categoryId, @PathVariable int postId,
			@RequestBody Post post, HttpServletResponse res) {
		Post updatedPost = postService.updatePostByLoggedInUser(postId, categoryId, userId, post, username);
		if (updatedPost == null) {
			res.setStatus(400);
			return null;
		}
		res.setStatus(200);
		return updatedPost;
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

	@RequestMapping(path = "posts/search/{name}", method = RequestMethod.GET)
	public List<Post> findByNameContaining(@PathVariable String name) {
		return postService.findByName(name);
	}

}
