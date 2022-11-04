package com.capstone.inventorymanagement.dto;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.capstone.inventorymanagement.domain.User;

public class LoginDtoInTest {
	@Test
	public void loginDtoInTest() {
		LoginDtoIn loginDtoIn = new LoginDtoIn();

		assertNull(loginDtoIn.getEmail());
		String email = "email";
		loginDtoIn.setEmail(email);
		assertEquals(email, loginDtoIn.getEmail());

		assertNull(loginDtoIn.getPassword());
		String password = "password";
		loginDtoIn.setPassword(password);
		assertEquals(password, loginDtoIn.getPassword());

	}

	@Test
	public void loginDtoIn__HashCOde_andEquals_test() {
		User user = new User();
		String email = "email";
		String password = "password";
		LoginDtoIn loginDtoIn = new LoginDtoIn(email, password);
		LoginDtoIn loginDtoIn1 = new LoginDtoIn(email, password);
		assertEquals(false, loginDtoIn.equals(null));
		assertEquals(true, loginDtoIn.equals(loginDtoIn1));
		assertEquals(loginDtoIn1, loginDtoIn1);
		assertEquals(loginDtoIn.hashCode(), loginDtoIn1.hashCode());
		assertEquals(false, loginDtoIn.equals(user));
	}

	@Test
	public void loginDtoIn__toString_test() {
		String email = "email";
		String password = "password";
		LoginDtoIn loginDtoIn = new LoginDtoIn(email, password);
		assertNotNull(loginDtoIn);
	}

}
