package com.skilldistillery.overflow.services;

import com.skilldistillery.overflow.entities.User;
import com.skilldistillery.overflow.entities.UserDTO;

public interface UserService {
	
	User createUser(UserDTO dto);

	// COMMENTING OUT BECAUSE WE CURRENTLY DO NOT WANT TO DELETE USERS
//	boolean deleteUser(int userId);

	User updateUserByLoggedInUser(User user, String username);
	
	
	
	
	
	
	
	
	
	
}
