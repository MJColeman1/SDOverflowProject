package com.skilldistillery.overflow.services;

import java.util.List;

import com.skilldistillery.overflow.entities.Employer;

public interface EmployerService {
	
	List<Employer> getAllEmployers();
	
	Employer findEmployerById(int empId);
	
	Employer createNewEmployer(int userId, Employer employer, String username);
	
	Employer updateEmployerById(int userId, int empId, Employer employer, String username);
	
	Boolean deleteEmployerById(int userId, int empId, String username);
	
}
