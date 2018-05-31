package com.skilldistillery.overflow.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.overflow.entities.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Integer>{

}
