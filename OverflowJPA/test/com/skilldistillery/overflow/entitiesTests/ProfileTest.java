package com.skilldistillery.overflow.entitiesTests;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.skilldistillery.overflow.entities.Profile;

class ProfileTest {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private Profile profile;
	
	@BeforeEach
	void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("Overflow");
		em = emf.createEntityManager();
		profile = em.find(Profile.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		emf.close();
		profile = null;
	}

	@Test
	@DisplayName("Test Profile is correctly mapped")
	void test_profile_mappings() {
		assertEquals("SD14", profile.getCohort());
		assertEquals("123 Hello World Lane", profile.getAddress().getStreet());
		assertEquals("Taco Bell", profile.getEmployer().getName());
		assertEquals(0, profile.getTechnologies().size());
	}

}
