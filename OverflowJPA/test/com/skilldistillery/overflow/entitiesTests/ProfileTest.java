package com.skilldistillery.overflow.entitiesTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		emf = Persistence.createEntityManagerFactory("EventTrackerProject");
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
		assertEquals("", profile.getId());
		assertEquals("", profile.getFirstName());
		assertEquals("", profile.getLastName());
		assertEquals("", profile.getEmail());
		assertEquals("", profile.getCohort());
	}

}