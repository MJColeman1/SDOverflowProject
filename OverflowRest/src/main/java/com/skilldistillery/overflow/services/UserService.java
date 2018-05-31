package com.skilldistillery.overflow.services;

import com.skilldistillery.overflow.entities.Address;
import com.skilldistillery.overflow.entities.Employer;
import com.skilldistillery.overflow.entities.ProfileDTO;
import com.skilldistillery.overflow.entities.Technology;
import com.skilldistillery.overflow.entities.User;
import com.skilldistillery.overflow.entities.UserDTO;

public interface UserService {
	
	User createUser(UserDTO dto);
	
	User updateUser(User user, ProfileDTO dto, Address address, Employer employer, Technology technology);
	
	boolean deleteUser(int id);
	
	boolean isUserNameTaken(String userName);
	
	User login(String userName, String password);
	
	
	
	
}
