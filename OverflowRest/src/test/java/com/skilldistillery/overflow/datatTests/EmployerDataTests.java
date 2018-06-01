package com.skilldistillery.overflow.datatTests;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.skilldistillery.overflow.respositories.EmployerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployerDataTests {

	private EmployerRepository er;
	
	@Test
	@DisplayName("Test Employer is correctly mapped")
	public void test_employer_mappings() {
		fail("Not yet implemented");
	}

}
