package com.skilldistillery.overflow.datatTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.skilldistillery.overflow.respositories.TechnologyRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TechnologyDataTests {
	
	@Autowired
	private TechnologyRepository tr;

	@Test
	@DisplayName("Test Technology is correctly mapped")
	public void test_technology_mappings() {
		assertEquals("Java", tr.findById(1).get().getName());
	}
	
	@Test
	@DisplayName("Test findByName")
	public void test_findByNames() {
		assertEquals("Java was created by Sun Microsystems", tr.findByName("Java").getDescription());
	}
	
	@Test
	@DisplayName("Test findTechnologyByEmployersId")
	public void test_findTechnologyByEmployersId() {
		assertEquals("Java was created by Sun Microsystems", tr.findTechnologyByEmployersId(1).get(0).getDescription());
	}

}
