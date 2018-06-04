package com.skilldistillery.overflow.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.overflow.entities.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Integer>{

	public Employer findByName(String name);
	
	@Query("SELECT e FROM Employer e JOIN FETCH e.technologies WHERE e.id = :id")
	public Employer getEmployerJoinedWithTechnologies(@Param("id") int employerId);
	
}
