package com.skilldistillery.overflow.services;

import java.util.List;

import com.skilldistillery.overflow.entities.Address;
import com.skilldistillery.overflow.entities.Employer;
import com.skilldistillery.overflow.entities.Profile;
import com.skilldistillery.overflow.entities.ProfileDTO;
import com.skilldistillery.overflow.entities.Technology;
import com.skilldistillery.overflow.entities.User;
import com.skilldistillery.overflow.entities.UserDTO;

public interface UserService {
	
	User createUser(UserDTO dto);
	
	boolean deleteUser(int userId);
	
	
	
	
	
	
	
	
	
	
}
