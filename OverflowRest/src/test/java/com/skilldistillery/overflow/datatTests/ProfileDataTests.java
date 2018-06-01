package com.skilldistillery.overflow.datatTests;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.skilldistillery.overflow.respositories.ProfileRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfileDataTests {

	private ProfileRepository pr;
	
	@Test
	@DisplayName("Test Profile is correctly mapped")
	public void test_profile_mappings() {
		fail("Not yet implemented");
	}

}
