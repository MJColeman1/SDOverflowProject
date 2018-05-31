package com.skilldistillery.overflow.entities;

public class UserDTO {

	private String userUsername;
	
	private String userPassword;
	
	private String profileFirstName;
	
	private String profileLastName;
	
	private String profileEmail;

	public String getUserUsername() {
		return userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getProfileFirstName() {
		return profileFirstName;
	}

	public void setProfileFirstName(String profileFirstName) {
		this.profileFirstName = profileFirstName;
	}

	public String getProfileLastName() {
		return profileLastName;
	}

	public void setProfileLastName(String profileLastName) {
		this.profileLastName = profileLastName;
	}

	public String getProfileEmail() {
		return profileEmail;
	}

	public void setProfileEmail(String profileEmail) {
		this.profileEmail = profileEmail;
	}
	
	
}
