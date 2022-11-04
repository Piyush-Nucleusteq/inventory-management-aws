package com.capstone.inventorymanagement.dto;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.capstone.inventorymanagement.domain.User;

public class LoginDtoOutTest {

	@Test
	public void LoginDtoOutTest() {

		LoginDtoOut loginDtoOut = new LoginDtoOut();
		assertNull(loginDtoOut.getFirstName());
		String firstName = "firstName";
		loginDtoOut.setFirstName(firstName);
		assertEquals(firstName, loginDtoOut.getFirstName());

		assertNull(loginDtoOut.getRole());
		String role = "role";
		loginDtoOut.setRole(role);
		assertEquals(role, loginDtoOut.getRole());

		assertNull(loginDtoOut.getEmployeeId());
		String employeeId = "N00011";
		loginDtoOut.setEmployeeId(employeeId);
		assertEquals(employeeId, loginDtoOut.getEmployeeId());

	}

	@Test
	public void LoginDtoOut_HashCOde_andEquals_test() {
		User user = new User();
		String firstName = "firstname";
		String role = "role";
		LoginDtoOut loginDtoOut1 = new LoginDtoOut(firstName, role);
		LoginDtoOut loginDtoOut2 = new LoginDtoOut(firstName, role);

		assertEquals(false, loginDtoOut1.equals(null));
		assertEquals(loginDtoOut1.hashCode(),
				loginDtoOut2.hashCode());
		assertEquals(false, loginDtoOut1.equals(user));
		assertEquals(true, loginDtoOut1.equals(loginDtoOut2));
		assertEquals(loginDtoOut1, loginDtoOut2);
	}

	@Test
	public void LoginDtoOut_toString_test() {

		String firstName = "firstname";
		String role = "role";
		LoginDtoOut loginDtoOut1 = new LoginDtoOut(firstName, role);
		assertNotNull(loginDtoOut1.toString());

	}

}
