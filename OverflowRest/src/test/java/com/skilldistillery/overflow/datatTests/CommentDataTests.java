package com.skilldistillery.overflow.datatTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.skilldistillery.overflow.respositories.CommentRepository;
import com.skilldistillery.overflow.services.CommentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentDataTests {

	@Autowired
	private CommentRepository cr;
	
	@Autowired
	private CommentService sr;
	
	@Test
	@DisplayName("Test getCommentsforUser")
	public void test_getCommentsforUser() {
		assertEquals("Java is awesome", cr.getCommentsforUser(1).get(0).getDescription());
	}
	
	@Test
	@DisplayName("Test getAllComments")
	public void test_getAllComments() {
		assertEquals("Java is awesome", sr.getAllComments(1).get(0).getDescription());
	}
	
	@Test
	@DisplayName("Test findCommentByPostId")
	public void test_findCommentByPostId() {
		assertEquals("Java is awesome", sr.findCommentByPostId(1, 1).getDescription());
	}
	
}
