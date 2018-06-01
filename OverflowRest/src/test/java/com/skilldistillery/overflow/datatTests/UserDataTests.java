package com.skilldistillery.overflow.datatTests;

import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.skilldistillery.overflow.entities.User;

class UserDataTests {

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
	void test_user_mappings() {
		fail("Not yet implemented");
	}

}
