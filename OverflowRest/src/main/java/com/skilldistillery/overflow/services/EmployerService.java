package com.skilldistillery.overflow.services;

import java.util.List;

import com.skilldistillery.overflow.entities.Employer;
import com.skilldistillery.overflow.entities.EmployerDTO;

public interface EmployerService {
	
	List<Employer> getAllEmployers();
	
	Employer findEmployerById(int empId);
	
	Employer createNewEmployer(int userId, EmployerDTO dto, String username);
	
	Employer updateEmployerById(int userId, int empId, EmployerDTO dto, String username);
	
	Boolean deleteEmployerById(int userId, int empId, String username);
	
}
