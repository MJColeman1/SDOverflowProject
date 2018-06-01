package com.skilldistillery.overflow.services;

import java.util.List;

import com.skilldistillery.overflow.entities.Technology;

public interface TechnologyService {
	
	public List<Technology> index();
	
	public Technology findById(int techId);
	
	public Technology create(Technology tech);
	
	public Technology update(Technology tech, int techId);
	
	public boolean destroy(int techId);

}
