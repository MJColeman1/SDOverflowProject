package com.skilldistillery.overflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.overflow.entities.Profile;
import com.skilldistillery.overflow.entities.User;
import com.skilldistillery.overflow.entities.UserDTO;
import com.skilldistillery.overflow.respositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;

	@Override
	public User createUser(UserDTO dto) {
		User user = new User();
		Profile profile = new Profile();
		user.setUsername(dto.getUserUsername());
		user.setPassword(dto.getUserPassword());
		user.setEnabled(true);
		user.setRole("standard");
		profile.setFirstName(dto.getProfileFirstName());
		profile.setLastName(dto.getProfileLastName());
		profile.setEmail(dto.getProfileEmail());
		user.setProfile(profile);
		userRepo.saveAndFlush(user);
		return user;
	}

	// COMMENTING OUT BECAUSE WE DO NOT CURRENTLY WANT TO DELETE USERS
//	@Override
//	public boolean deleteUser(int userId) {
//		try {
//			userRepo.deleteById(userId);
//			return true;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
	
	@Override
	public User updateUserByLoggedInUser(User user, String username) {
		User managedUser = userRepo.findByUsername(username);
		try {
			managedUser = userRepo.findByUsername(username);
			managedUser.setUsername(user.getUsername());
			managedUser.setPassword(user.getPassword());
			userRepo.saveAndFlush(managedUser);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return managedUser;
	}

}
