package com.skilldistillery.overflow.services;

import com.skilldistillery.overflow.entities.Profile;
import com.skilldistillery.overflow.entities.ProfileDTO;
import com.skilldistillery.overflow.entities.Technology;

public interface ProfileService {

	Profile updateProfileByLoggedInUser( ProfileDTO dto, String username);
	
	Profile addTechnologyForLoggedInUser(Technology technology, String username);
	
	Profile deleteTechnologyForLoggedInUser(Technology technology, String username);

	Profile getProfileByUsername(String username);
	
}