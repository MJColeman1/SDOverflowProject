package com.skilldistillery.overflow.entitiesTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.skilldistillery.overflow.entities.Technology;

class TechnologyTest {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private Technology technology;
	
	@BeforeEach
	void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("Overflow");
		em = emf.createEntityManager();
		technology = em.find(Technology.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		emf.close();
		technology = null;
	}

	@Test
	@DisplayName("Test Technology is correctly mapped")
	void test_technology_mappings() {
		assertEquals("Java", technology.getName());
		assertEquals("80,000", technology.getPayscale());
		assertEquals(0, technology.getProfiles().size());
		assertEquals(0, technology.getEmployers().size());
	}

}
