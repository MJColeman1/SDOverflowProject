package com.skilldistillery.overflow.entities;

public class ProfileDTO {
	
	private String addressStreet;
	
	private String addressStreet2;
	
	private String addressCity;
	
	private String addressState;
	
	private String addressCountry;
	
	private String addressZip;
	
	private String employerName;
	
	private String employerHiring;
	
	private String profileFirstName;
	
	private String profileLastName;

	private String profileEmail;

	private String profileCohort;

	private boolean profileEmployed;
	
	private String employerAddressStreet;
	
	private String employerAddressStreet2;
	
	private String employerAddressCity;
	
	private String employerAddressState;
	
	private String employerAddressCountry;
	
	private String employerAddressZip;
	
	// END OF FIELDS
	
	private ProfileDTO() {
		
	}
	
	// END OF CONSTRUCTORS

	public String getEmployerAddressStreet() {
		return employerAddressStreet;
	}

	public void setEmployerAddressStreet(String employerAddressStreet) {
		this.employerAddressStreet = employerAddressStreet;
	}

	public String getEmployerAddressStreet2() {
		return employerAddressStreet2;
	}

	public void setEmployerAddressStreet2(String employerAddressStreet2) {
		this.employerAddressStreet2 = employerAddressStreet2;
	}

	public String getEmployerAddressCity() {
		return employerAddressCity;
	}

	public void setEmployerAddressCity(String employerAddressCity) {
		this.employerAddressCity = employerAddressCity;
	}

	public String getEmployerAddressState() {
		return employerAddressState;
	}

	public void setEmployerAddressState(String employerAddressState) {
		this.employerAddressState = employerAddressState;
	}

	public String getEmployerAddressCountry() {
		return employerAddressCountry;
	}

	public void setEmployerAddressCountry(String employerAddressCountry) {
		this.employerAddressCountry = employerAddressCountry;
	}

	public String getEmployerAddressZip() {
		return employerAddressZip;
	}

	public void setEmployerAddressZip(String employerAddressZip) {
		this.employerAddressZip = employerAddressZip;
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

	public String getProfileCohort() {
		return profileCohort;
	}

	public void setProfileCohort(String profileCohort) {
		this.profileCohort = profileCohort;
	}

	public boolean isProfileEmployed() {
		return profileEmployed;
	}

	public void setProfileEmployed(boolean profileEmployed) {
		this.profileEmployed = profileEmployed;
	}

	// END OF GETS/SETS

}