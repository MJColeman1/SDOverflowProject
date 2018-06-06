package com.skilldistillery.overflow.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.overflow.entities.Employer;
import com.skilldistillery.overflow.entities.EmployerDTO;
import com.skilldistillery.overflow.services.EmployerService;

@RestController
@CrossOrigin({"*", "http://localhost:4200"})
@RequestMapping(path = "/api")
public class EmployerController {

	@Autowired
	private EmployerService empService;

	private String username = "jackson";

	@RequestMapping(path = "/employers", method = RequestMethod.GET)
	public List<Employer> index(Principal principal) {
		return empService.getAllEmployers(principal.getName());
	}

	@RequestMapping(path = "/employers/{empId}", method = RequestMethod.GET)
	public Employer show(@PathVariable int empId, Principal principal) {
		return empService.findEmployerById(empId, principal.getName());
	}

	@RequestMapping(path = "/user/{userId}/employers", method = RequestMethod.POST)
	public Employer create(@PathVariable int userId, @RequestBody EmployerDTO dto, HttpServletResponse res, Principal principal) {
		Employer newEmployer = empService.createNewEmployer(userId, dto, principal.getName()); 
		if (newEmployer != null) {
			res.setStatus(201);
			return newEmployer;
		}
		res.setStatus(400);
		return null;
	}
	
	@RequestMapping(path="employers/{empId}/technology/{techId}", method=RequestMethod.PUT)
	public Employer addTechnology(@PathVariable int empId, @PathVariable int techId, Principal principal) {
		return empService.addTechnology(techId, empId);
	}
}
