package com.skilldistillery.overflow.datatTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.skilldistillery.overflow.entities.Employer;
import com.skilldistillery.overflow.entities.Technology;
import com.skilldistillery.overflow.respositories.EmployerRepository;
import com.skilldistillery.overflow.respositories.TechnologyRepository;
import com.skilldistillery.overflow.services.EmployerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployerDataTests {

	@Autowired
	private EmployerRepository er;
	
	@Autowired
	private EmployerService  es;
	
	@Autowired
	private TechnologyRepository  tr;
	
	@Test
	@DisplayName("Test getAllEmployers")
	public void test_getAllEmployers() {
		assertEquals("Taco Bell", es.getAllEmployers().get(0).getName());
	}
	
	@Test
	@DisplayName("Test findEmployerById")
	public void test_findEmployerById() {
		assertEquals("Taco Bell", es.findEmployerById(1).getName());
	}
	
	@Test
	@DisplayName("Test addTechnology")
	public void test_addTechnology() {
		Employer employer = er.findByName("Taco Bell");
		Technology technology = tr.findByName("Java");
		es.addTechnology(employer.getId(), technology.getId());
		assertEquals("Java", es.getTechnologiesForEmployer(employer.getId()).get(0).getName());
	}	

}
