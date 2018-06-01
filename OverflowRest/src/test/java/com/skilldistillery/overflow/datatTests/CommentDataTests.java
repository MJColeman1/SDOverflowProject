package com.skilldistillery.overflow.datatTests;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.skilldistillery.overflow.respositories.CommentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentDataTests {

	@Autowired
	private CommentRepository cr;
	
	@Test
	@DisplayName("Test Comment is correctly mapped")
	public void test_comment_mappings() {
		fail("Not yet implemented");
	}
}
