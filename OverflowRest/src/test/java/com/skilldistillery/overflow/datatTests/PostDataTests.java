package com.skilldistillery.overflow.datatTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.skilldistillery.overflow.respositories.PostRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostDataTests {

	@Autowired
	private PostRepository pr;
	
	@Test
	@DisplayName("Test Post is correctly mapped")
	public void test_post_mappings() {
		assertEquals("Java question", pr.getPostsForUser(1).get(0).getName());
	}

}
