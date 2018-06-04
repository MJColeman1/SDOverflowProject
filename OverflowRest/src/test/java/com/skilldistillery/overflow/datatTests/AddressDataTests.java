package com.skilldistillery.overflow.datatTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.skilldistillery.overflow.respositories.AddressRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressDataTests {
	
	@Autowired
	private AddressRepository ar;
	
	@Test
	@DisplayName("Test Address is correctly mapped")
	public void test_address_mappings() {
		assertEquals("123 Hello World Lane", ar.findById(1).get().getStreet());
	}

}
