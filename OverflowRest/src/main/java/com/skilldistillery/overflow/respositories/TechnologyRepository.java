package com.skilldistillery.overflow.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.overflow.entities.Employer;
import com.skilldistillery.overflow.entities.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Integer>{

//	THIS IS PROBABLY WORKING BUT THERE IS A METHOD IN THE EMPLOYER DOING THE SAME THING
//	@Query("SELECT t FROM Technology t JOIN FETCH t.employers WHERE :employer MEMBER OF t.employers")
//	public List<Technology> getTechnologiesForEmployers(@Param("employer") Employer employerId);
	
	public List<Technology> findTechnologyByEmployersId(int employerId);
	
	public Technology findByName(String name);
}
