package com.skilldistillery.overflow.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.overflow.entities.Technology;
import com.skilldistillery.overflow.services.TechnologyService;

@RestController
@RequestMapping("api")
public class TechnologyController {

	
	@Autowired
	private TechnologyService techService;
	
	@RequestMapping(path="technologies", method=RequestMethod.GET)
	public List<Technology> index() {
		return techService.index();
	}
	
	@RequestMapping(path="technology/{techId}", method=RequestMethod.GET)
	public Technology show(@PathVariable int techId) {
		return techService.findById(techId);
	}
	
	@RequestMapping(path="technology", method=RequestMethod.POST)
	public Technology create(@RequestBody Technology tech) {
		return techService.create(tech);
	}
	
	@RequestMapping(path="technology/{techId}", method=RequestMethod.PUT)
	public Technology update(@RequestBody Technology tech, @PathVariable int techId) {
		return techService.update(tech, techId);
	}
	
	@RequestMapping(path="technology/{techId}", method=RequestMethod.DELETE)
	public boolean destroy(@PathVariable int techId) {
		return techService.destroy(techId);
	}
}
