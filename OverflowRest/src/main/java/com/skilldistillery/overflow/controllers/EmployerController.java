package com.skilldistillery.overflow.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.overflow.entities.Employer;
import com.skilldistillery.overflow.services.EmployerService;

@RestController
@RequestMapping(path = "/api")
public class EmployerController {

	@Autowired
	private EmployerService empService;
	
	private String username = "jackson";
	
	@RequestMapping(path = "/employers", method = RequestMethod.GET)
	public List<Employer> index() {
		return empService.getAllEmployers();
	}
	
	@RequestMapping(path = "/employers/{empId}", method = RequestMethod.GET)
	public Employer show(@PathVariable int empId) {
		return empService.findEmployerById(empId);
	}
}
