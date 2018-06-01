package com.skilldistillery.overflow.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.overflow.entities.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Integer>{

//	@Query("SELECT t FROM Technology t JOIN FETCH t.employers")
//	public List<Technology> getTechnologiesForEmployers(@Param("id") int employerId);
	
	
	public List<Technology> findTechnologyByEmployersId(int employerId);
}
