package com.skilldistillery.overflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.overflow.entities.Employer;
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
	public Employer createNewEmployer(int userId, Employer employer, String username) {
		User user = userRepo.findById(userId).get();
		if (user.getUsername().equals(username)) {
			empRepo.saveAndFlush(employer);
		}
		return null;
	}

	@Override
	public Employer updateEmployerById(int userId, int empId, Employer employer, String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteEmployerById(int userId, int empId, String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
