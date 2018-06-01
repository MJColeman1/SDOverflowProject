package com.skilldistillery.overflow.datatTests;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.skilldistillery.overflow.respositories.TechnologyRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TechnologyDataTests {
	
	private TechnologyRepository tr;

	@Test
	@DisplayName("Test Technology is correctly mapped")
	public void test_technology_mappings() {
		fail("Not yet implemented");
	}

}
