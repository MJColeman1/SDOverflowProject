package com.skilldistillery.overflow.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.overflow.entities.Profile;
import com.skilldistillery.overflow.entities.User;
import com.skilldistillery.overflow.entities.UserDTO;
import com.skilldistillery.overflow.respositories.UserRepository;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User createUser(UserDTO dto) {
		User user = new User();
		Profile profile = new Profile();

		user.setUsername(dto.getUserUsername());
		user.setPassword(dto.getProfileEmail());
		profile.setFirstName(dto.getProfileFirstName());
		profile.setLastName(dto.getProfileLastName());
		profile.setEmail(dto.getProfileEmail());

		user.setProfile(profile);

		return userRepo.saveAndFlush(user);
		
	}

	@Override
	public boolean deleteUser(int userId) {
		try {
			userRepo.deleteById(userId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	public User updateUser(User user, int userId) {
		User managedUser = new User();
		Optional <User> opUser = userRepo.findById(userId);
		if(opUser.isPresent()) {
			managedUser = userRepo.findById(userId).get();
			managedUser.setUsername(user.getUsername());
			managedUser.setPassword(user.getPassword());
		}
		
		return managedUser;
		
	}

}
