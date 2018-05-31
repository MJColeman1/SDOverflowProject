package com.skilldistillery.overflow.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.overflow.respositories.UserRepository;


public class UserServiceImpl implements UserService{

	@Autowired
	public UserRepository userRepo;
}
