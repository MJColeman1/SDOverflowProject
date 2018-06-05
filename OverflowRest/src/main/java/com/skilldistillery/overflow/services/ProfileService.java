package com.skilldistillery.overflow.services;

import com.skilldistillery.overflow.entities.Profile;
import com.skilldistillery.overflow.entities.ProfileDTO;
import com.skilldistillery.overflow.entities.Technology;

public interface ProfileService {

	Profile updateProfileByLoggedInUser( ProfileDTO dto, String username);
	
	Profile addTechnology(Technology technology, String username);
	
	Profile deleteTechnology(Technology technology, String username);
	
	Profile removeEmployer(String username);

	Profile removeAddress(String username);

	
	
	
	
}