package com.skilldistillery.overflow.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.overflow.entities.Profile;
import com.skilldistillery.overflow.entities.ProfileDTO;
import com.skilldistillery.overflow.entities.Technology;
import com.skilldistillery.overflow.entities.User;
import com.skilldistillery.overflow.respositories.ProfileRepository;
import com.skilldistillery.overflow.respositories.UserRepository;
import com.skilldistillery.overflow.services.ProfileService;

@RestController
@CrossOrigin({ "*", "http://localhost:4200" })
@RequestMapping(path = "/api")
public class ProfileController {
	
	@Autowired
	private ProfileService ps;
	
	@Autowired
	private ProfileRepository pr;
	
	@Autowired
	private UserRepository ur;
	
	@RequestMapping(path="/profile", method=RequestMethod.GET)
	public User getProfile(HttpServletRequest req, HttpServletResponse res, Principal principal) {
		User u = ur.findByUsername(principal.getName());
		if (u != null) {
			res.setStatus(200);
			return u;
		}
		res.setStatus(400);
		return null;
	}
	
	@RequestMapping(path="/profile", method=RequestMethod.PUT)
	public Profile updateProfile(@RequestBody ProfileDTO dto, HttpServletRequest req, HttpServletResponse res, Principal principal) {
		Profile p = ps.updateProfileByLoggedInUser(dto, principal.getName());
		if (p != null) {
			res.setStatus(200);
			return p;
		}
		res.setStatus(400);
		return null;
	}
	
	@RequestMapping(path="/profile/{bool}", method=RequestMethod.PATCH)
	public Profile changeTechnologies(@RequestBody Technology technology, @PathVariable int bool, HttpServletRequest req, HttpServletResponse res, Principal principal) {
		Profile p = pr.findProfileByUserUsername(principal.getName());
		if (bool == 1) {
			p = ps.addTechnologyForLoggedInUser(technology, principal.getName());
			return p;
		}
		if (bool == 0) {
			p = ps.deleteTechnologyForLoggedInUser(technology, principal.getName());
			return p;
		}
		return p;
	}

}
