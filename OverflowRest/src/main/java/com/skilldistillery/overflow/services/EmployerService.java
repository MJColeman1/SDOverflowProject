package com.skilldistillery.overflow.services;

import java.util.List;

import com.skilldistillery.overflow.entities.Employer;
import com.skilldistillery.overflow.entities.EmployerDTO;
import com.skilldistillery.overflow.entities.Technology;

public interface EmployerService {
	
	List<Employer> getAllEmployers(String username);
	
	Employer findEmployerById(int empId, String username);
	
	Employer createNewEmployer(int userId, EmployerDTO dto, String username);
	
	Employer updateEmployerById(int userId, int empId, EmployerDTO dto, String username);
	
	Boolean deleteEmployerById(int userId, int empId, String username);
	
	Employer addTechnology(int techId, int empId);

	List<Technology> getTechnologiesForEmployer(int employerId);
}
