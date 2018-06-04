package com.skilldistillery.overflow.services;

import com.skilldistillery.overflow.entities.User;
import com.skilldistillery.overflow.entities.UserDTO;

public interface UserService {
	
	User createUser(UserDTO dto);
	
	boolean deleteUser(int userId);

	User updateUser(User user, int userId);
	
	
	
	
	
	
	
	
	
	
}
