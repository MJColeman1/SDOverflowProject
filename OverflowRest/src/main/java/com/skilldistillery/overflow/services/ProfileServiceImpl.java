package com.skilldistillery.overflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.overflow.entities.Address;
import com.skilldistillery.overflow.entities.Employer;
import com.skilldistillery.overflow.entities.Profile;
import com.skilldistillery.overflow.entities.ProfileDTO;
import com.skilldistillery.overflow.entities.Technology;
import com.skilldistillery.overflow.respositories.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepository profileRepo;

	@Override
	public Profile updateProfile(ProfileDTO dto, Address address, Employer employer, Profile profile,
			Address employerAddress) {

		address.setStreet(dto.getAddressStreet());
		address.setStreet2(dto.getAddressStreet2());
		address.setCity(dto.getAddressCity());
		address.setState(dto.getAddressState());
		address.setCountry(dto.getAddressCountry());
		address.setZip(dto.getAddressZip());

		employerAddress.setStreet(dto.getEmployerAddressStreet());
		employerAddress.setStreet2(dto.getEmployerAddressStreet2());
		employerAddress.setCity(dto.getEmployerAddressCity());
		employerAddress.setState(dto.getEmployerAddressState());
		employerAddress.setCountry(dto.getEmployerAddressCountry());
		employerAddress.setZip(dto.getEmployerAddressZip());

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
	public Profile addTechnology(Technology technology) {
		// TODO Auto-generated method stub
		return null;
	}
	public Profile deleteTechnology(Technology technology) {
		
		return null;
		
	}
	
}
