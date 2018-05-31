package com.skilldistillery.overflow.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	
	private String password;
	
	private String role;
	
	private boolean enabled;
	
	private boolean admin;
	
	@JoinColumn(name = "profile_id")
	private Profile profile;
	
}
