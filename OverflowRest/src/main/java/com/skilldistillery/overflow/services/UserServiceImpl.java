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
		user.setPassword(dto.getProfileEmail());
		profile.setFirstName(dto.getProfileFirstName());
		profile.setLastName(dto.getProfileLastName());
		profile.setEmail(dto.getProfileEmail());
		
		user.setProfile(profile);
		
		
		 userRepo.saveAndFlush(user);
		 return user;
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

}
