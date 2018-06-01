package com.skilldistillery.overflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.overflow.entities.Address;
import com.skilldistillery.overflow.entities.Employer;
import com.skilldistillery.overflow.entities.EmployerDTO;
import com.skilldistillery.overflow.entities.User;
import com.skilldistillery.overflow.respositories.EmployerRepository;
import com.skilldistillery.overflow.respositories.UserRepository;

@Service
public class EmployerServiceImpl implements EmployerService{
	@Autowired
	private EmployerRepository empRepo;
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<Employer> getAllEmployers() {
		return empRepo.findAll();
	}

	@Override
	public Employer findEmployerById(int empId) {
		return empRepo.findById(empId).get();
	}

	@Override
	public Employer createNewEmployer(int userId, EmployerDTO dto, String username) {
		User user = userRepo.findById(userId).get();
		if (user.getUsername().equals(username)) {
			// MAKE A NEW ADDRESS WITH DTO FORM DATA
			Address address = new Address();
			address.setStreet(dto.getEmployerStreet());
			address.setStreet(dto.getEmployerStreet2());
			address.setCity(dto.getEmployerCity());
			address.setState(dto.getEmployerState());
			address.setCountry(dto.getEmployerCountry());
			address.setZip(dto.getEmployerZip());
			// MAKE A NEW EMPLOYER WITH DTO FORM DATA, SET ADDRESS AS IT'S ADDRESS
			Employer employer = new Employer();
			employer.setName(dto.getEmployerName());
			employer.setHiring(dto.getEmployerHiring());
			employer.setAddress(address);
			// SAVE EMPLOYER, ADDRESS WILL BE CASCADED
			empRepo.saveAndFlush(employer);
		}
		return null;
	}

	@Override
	public Employer updateEmployerById(int userId, int empId, EmployerDTO dto, String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteEmployerById(int userId, int empId, String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
