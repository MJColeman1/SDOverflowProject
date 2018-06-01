package com.skilldistillery.overflow.datatTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.skilldistillery.overflow.respositories.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDataTests {
	
	@Autowired
	private UserRepository userRepo;

	@Test
	@DisplayName("Test User is correctly mapped")
	 public void test_user_mappings() {
		
		assertEquals("jackson", userRepo.findByUsername("jackson").getUsername());
	}

}
