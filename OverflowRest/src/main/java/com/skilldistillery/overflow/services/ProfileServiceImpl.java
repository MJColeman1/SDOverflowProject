package com.skilldistillery.overflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.overflow.entities.Address;
import com.skilldistillery.overflow.entities.Employer;
import com.skilldistillery.overflow.entities.Post;
import com.skilldistillery.overflow.entities.Profile;
import com.skilldistillery.overflow.entities.ProfileDTO;
import com.skilldistillery.overflow.entities.Technology;
import com.skilldistillery.overflow.entities.User;
import com.skilldistillery.overflow.respositories.ProfileRepository;
import com.skilldistillery.overflow.respositories.UserRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepository profileRepo;
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public Profile updateProfile(ProfileDTO dto, int profileId) {
		
		Profile profile = profileRepo.findById(profileId).get();

		Address address = new Address();
		address.setStreet(dto.getAddressStreet());
		address.setStreet2(dto.getAddressStreet2());
		address.setCity(dto.getAddressCity());
		address.setState(dto.getAddressState());
		address.setCountry(dto.getAddressCountry());
		address.setZip(dto.getAddressZip());

		Address employerAddress = new Address();
		employerAddress.setStreet(dto.getEmployerAddressStreet());
		employerAddress.setStreet2(dto.getEmployerAddressStreet2());
		employerAddress.setCity(dto.getEmployerAddressCity());
		employerAddress.setState(dto.getEmployerAddressState());
		employerAddress.setCountry(dto.getEmployerAddressCountry());
		employerAddress.setZip(dto.getEmployerAddressZip());
		
		Employer employer = new Employer();
		employer.setName(dto.getEmployerName());
		employer.setAddress(employerAddress);
		employer.setHiring(dto.getEmployerHiring());

		profile.setFirstName(dto.getProfileFirstName());
		profile.setLastName(dto.getProfileLastName());
		profile.setEmail(dto.getProfileEmail());
		profile.setCohort(dto.getProfileCohort());
		profile.setEmployed(dto.isProfileEmployed());
		profile.setEmployer(employer);
		profile.setAddress(address);

		return profileRepo.saveAndFlush(profile);
	}

	@Override
	public Profile addTechnology(Technology technology, int profileId) {
		Profile profile = profileRepo.findById(profileId).get();
		profile.addTechnology(technology);
		return profile;
	}
	@Override
	public Profile deleteTechnology(Technology technology, int profileId) {
		Profile profile = profileRepo.findById(profileId).get();
		profile.deleteTechnology(technology);
		return profile;
		
	}

	@Override
	public Profile removeEmployer(int profileId) {
		Profile profile = profileRepo.findById(profileId).get();
		profile.setEmployer(null);
		
		return profile;
	}
	
	
}
