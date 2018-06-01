package com.skilldistillery.overflow.datatTests;

import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.skilldistillery.overflow.entities.Comment;

class CommentDataTests {

	private EntityManagerFactory emf;
	private EntityManager em;
	private Comment comment;

	@BeforeEach
	void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("Overflow");
		em = emf.createEntityManager();
		comment = em.find(Comment.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		emf.close();
		comment = null;
	}
	
	@Test
	@DisplayName("Test Comment is correctly mapped")
	void test_comment_mappings() {
		fail("Not yet implemented");
	}
}
