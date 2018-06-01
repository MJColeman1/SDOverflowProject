package com.skilldistillery.overflow.datatTests;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.skilldistillery.overflow.respositories.PostRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostDataTests {

	private PostRepository pr;
	
	@Test
	@DisplayName("Test Post is correctly mapped")
	public void test_post_mappings() {
		fail("Not yet implemented");
	}

}
