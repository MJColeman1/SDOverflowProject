package com.skilldistillery.overflow.entitiesTests;



import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.skilldistillery.overflow.entities.Post;

class PostTest {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private Post post;
	
	@BeforeEach
	void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("EventTrackerProject");
		em = emf.createEntityManager();
		post = em.find(Post.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		emf.close();
		post = null;
	}

	@Test
	@DisplayName("Test Post is correctly mapped")
	void test_post_mappings() {
		assertEquals("", post.getId());
		assertEquals("", post.getName());
		assertEquals("", post.getDescription());
		assertEquals("", post.getCreatedAt());
		assertEquals("", post.getUpdatedAt());
		assertEquals("", post.getCategory());
		assertEquals("", post.getUser());
	}

}
