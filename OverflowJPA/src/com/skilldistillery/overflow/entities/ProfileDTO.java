package com.skilldistillery.overflow.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class ProfileDTO {
	
	
	
	private String userUsername;
	
	private String userPassword;
	
	private String userRole;
	
	private boolean userEnabled;
	
	private Profile userProfile;
	
	private String addressStreet;
	
	private String addressStreet2;
	
	private String addressCity;
	
	private String addressState;
	
	private String addressCountry;
	
	private String addressZip;
	
	private String employerName;
	
	private String employerHiring;
	
	private String technologyName;
	
	private String technologyDescription;
	
	private String technologyPayscale;
	
	private String pofileFirstName;

	private String profileLastName;

	private String profileEmail;

	private String profileCohort;

	private boolean profileEmployed;

	

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

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public boolean isUserEnabled() {
		return userEnabled;
	}

	public void setUserEnabled(boolean userEnabled) {
		this.userEnabled = userEnabled;
	}

	public Profile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(Profile userProfile) {
		this.userProfile = userProfile;
	}

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public String getAddressStreet2() {
		return addressStreet2;
	}

	public void setAddressStreet2(String addressStreet2) {
		this.addressStreet2 = addressStreet2;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressState() {
		return addressState;
	}

	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}

	public String getAddressCountry() {
		return addressCountry;
	}

	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}

	public String getAddressZip() {
		return addressZip;
	}

	public void setAddressZip(String addressZip) {
		this.addressZip = addressZip;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getEmployerHiring() {
		return employerHiring;
	}

	public void setEmployerHiring(String employerHiring) {
		this.employerHiring = employerHiring;
	}

	public String getTechnologyName() {
		return technologyName;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}

	public String getTechnologyDescription() {
		return technologyDescription;
	}

	public void setTechnologyDescription(String technologyDescription) {
		this.technologyDescription = technologyDescription;
	}

	public String getTechnologyPayscale() {
		return technologyPayscale;
	}

	public void setTechnologyPayscale(String technologyPayscale) {
		this.technologyPayscale = technologyPayscale;
	}

	
	

}
