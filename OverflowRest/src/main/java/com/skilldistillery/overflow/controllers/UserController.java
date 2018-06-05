package com.skilldistillery.overflow.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.overflow.entities.User;
import com.skilldistillery.overflow.services.UserService;

@RestController
@CrossOrigin({ "*", "http://localhost:4200" })
public class UserController {
	
	@Autowired
	private UserService us;
	
	@RequestMapping(path="/user", method=RequestMethod.PUT)
	public User updateUser(@RequestBody User user, HttpServletRequest req, HttpServletResponse res, Principal principal) {
		User u = us.updateUserByLoggedInUser(user, principal.getName());
		if (u != null) {
			res.setStatus(200);
			return u;
		}
		res.setStatus(400);
		return null;
	}
	

}
