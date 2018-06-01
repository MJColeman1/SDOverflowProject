package com.skilldistillery.overflow.services;

import com.skilldistillery.overflow.entities.Address;
import com.skilldistillery.overflow.entities.Employer;
import com.skilldistillery.overflow.entities.Profile;
import com.skilldistillery.overflow.entities.ProfileDTO;
import com.skilldistillery.overflow.entities.Technology;

public interface ProfileService {

	Profile updateProfile( ProfileDTO dto, int profileId);
	
	Profile addTechnology(Technology technology, int profileId);
	
	Profile deleteTechnology(Technology technology,int profileId);
	
	Profile removeEmployer( int profileId);

	
	
	
	
}