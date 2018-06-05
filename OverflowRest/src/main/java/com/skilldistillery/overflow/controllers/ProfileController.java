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

import com.skilldistillery.overflow.entities.Profile;
import com.skilldistillery.overflow.entities.ProfileDTO;
import com.skilldistillery.overflow.services.ProfileService;

@RestController
@CrossOrigin({ "*", "http://localhost:4200" })
public class ProfileController {
	
	@Autowired
	private ProfileService ps;
	
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
	
//	@RequestMapping(path="/profile", method=RequestMethod.DELETE)
//	public Profile deleteFieldFromLoggedInUser(HttpServletRequest req, HttpServletResponse res, Principal principal) {
//		Profile p = ps.updateProfileByLoggedInUser(principal.getName());
//		if (p != null) {
//			res.setStatus(200);
//			return p;
//		}
//		res.setStatus(400);
//		return null;
//	}

}
