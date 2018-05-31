package com.skilldistillery.overflow.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.overflow.entities.Post;
import com.skilldistillery.overflow.entities.User;
import com.skilldistillery.overflow.services.PostService;

@RestController
@RequestMapping(path = "/api")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(path = "/posts", method = RequestMethod.GET)
	public List<Post> index(User user) {
		return postService.index(user);
	}
	
	@RequestMapping(path = "/posts/{postId}", method = RequestMethod.GET)
	public Post show(@PathVariable int postId, User user) {
		return postService.show(postId, user);
	}
	
	@RequestMapping(path = "/posts", method = RequestMethod.POST)
	public Post create(User user, @RequestBody Post post) {
		return postService.create(post, user);
	}
	
	@RequestMapping(path = "/posts/{postId}", method = RequestMethod.PUT)
	public Post update(@PathVariable int postId, User user, @RequestBody Post post) {
		return postService.update(postId, post, user);
	}
	
	@RequestMapping(path = "/posts/{postId}", method = RequestMethod.DELETE)
	public Boolean delete(@PathVariable int postId) {
		return postService.destroy(postId);
	}
	
}
