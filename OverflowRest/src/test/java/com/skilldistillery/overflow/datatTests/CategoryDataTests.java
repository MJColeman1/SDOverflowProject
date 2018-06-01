package com.skilldistillery.overflow.datatTests;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.skilldistillery.overflow.respositories.CategoryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryDataTests {

	@Autowired
	private CategoryRepository cr;
	
	@Test
	@DisplayName("Test Category is correctly mapped")
	public void test_category_mappings() {
		fail("Not yet implemented");
	}

}
