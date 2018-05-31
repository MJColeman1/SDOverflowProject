package com.skilldistillery.overflow.entitiesTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.skilldistillery.overflow.entities.Employer;

class EmployerTest {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private Employer employer;
	
	@BeforeEach
	void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("Overflow");
		em = emf.createEntityManager();
		employer = em.find(Employer.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		emf.close();
		employer = null;
	}

	@Test
	@DisplayName("Test Employer is correctly mapped")
	void test_employer_mappings() {
		assertEquals("Taco Bell", employer.getName());
		assertEquals("No", employer.getHiring());
		assertEquals("123 Hello World Lane", employer.getAddress().getStreet());
	}

}
