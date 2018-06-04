package com.skilldistillery.overflow.datatTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.skilldistillery.overflow.respositories.ProfileRepository;
import com.skilldistillery.overflow.services.ProfileService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfileDataTests {

	@Autowired
	private ProfileRepository pr;
	
	@Autowired
	private ProfileService ps;
	
	@Test
	@DisplayName("Test Profile is correctly mapped")
	public void test_profile_mappings() {
		assertEquals("Jackson", pr.findById(1).get().getFirstName());
	}
	
	@Test
	@DisplayName("Test findByCohort")
	public void test_findByCohort() {
		assertEquals("Jackson", pr.findByCohort("SD14").getFirstName());
	}

}
