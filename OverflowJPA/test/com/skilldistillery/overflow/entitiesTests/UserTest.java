package com.skilldistillery.overflow.entitiesTests;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.skilldistillery.overflow.entities.User;

class UserTest {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private User user;
	
	@BeforeEach
	void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("Overflow");
		em = emf.createEntityManager();
		user = em.find(User.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		emf.close();
		user = null;
	}

	@Test
	@DisplayName("Test User is correctly mapped")
	void testUserMappings() {
		assertEquals("jackson", user.getUsername());
		assertEquals("Jackson", user.getProfile().getFirstName());
		assertNotNull(user.getComments());
		assertEquals(1, user.getComments().size());
		assertEquals(1, user.getPosts().size());
	}
	

}
