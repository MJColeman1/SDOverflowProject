package com.skilldistillery.overflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skilldistillery.overflow.entities.User;
import com.skilldistillery.overflow.entities.UserDTO;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public User register(String json) {
		ObjectMapper om = new ObjectMapper();
		UserDTO dto = null;
		User user = null;
		try {
			dto = om.readValue(json, UserDTO.class);
			String encodedPW = encoder.encode(dto.getUserPassword());
			dto.setUserPassword(encodedPW);
			user = userService.createUser(dto);
		} catch (Exception e) {
			System.out.println(e);
		}		
		return user;
	}


}
