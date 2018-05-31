package com.skilldistillery.overflow.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.overflow.entities.Address;
import com.skilldistillery.overflow.entities.Employer;
import com.skilldistillery.overflow.entities.Profile;
import com.skilldistillery.overflow.entities.ProfileDTO;
import com.skilldistillery.overflow.entities.Technology;
import com.skilldistillery.overflow.entities.User;
import com.skilldistillery.overflow.entities.UserDTO;
import com.skilldistillery.overflow.respositories.UserRepository;


public class UserServiceImpl implements UserService{

	@Autowired
	public UserRepository userRepo;

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
	public User updateUser(User user, ProfileDTO dto, Address address, Employer employer, Technology technology) {
	address.setStreet(dto.getAddressStreet());
		return null;
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUserNameTaken(String userName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User login(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}
}
