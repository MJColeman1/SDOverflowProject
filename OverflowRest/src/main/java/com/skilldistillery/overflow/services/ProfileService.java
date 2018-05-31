package com.skilldistillery.overflow.services;

import com.skilldistillery.overflow.entities.Address;
import com.skilldistillery.overflow.entities.Employer;
import com.skilldistillery.overflow.entities.Profile;
import com.skilldistillery.overflow.entities.ProfileDTO;
import com.skilldistillery.overflow.entities.Technology;

public interface ProfileService {

	Profile updateProfile( ProfileDTO dto, Address address, Employer employer, 
			 Profile profile, Address employerAddress);
	
	Profile addTechnology(Technology technology);
	
	Profile deleteTechnology(Technology technology);

	
	
	
	
}