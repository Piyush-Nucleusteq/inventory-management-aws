package com.capstone.inventorymanagement.dto;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class AdminDtoOutTest {

	@Test
	public void adminDtoOutTest() {
		AdminDtoOut adminDtoOut = new AdminDtoOut();
		String employeeMEssage = "employee";
		adminDtoOut.setEmployeeMessage(employeeMEssage);
		assertEquals(employeeMEssage,
				adminDtoOut.getEmployeeMessage());

	}

	@Test
	public void toStringTEst() {
		String employeeMessage = "employee";
		AdminDtoOut adminDtoOut = buildAdminDtoOut(employeeMessage);
		assertNotNull(adminDtoOut.toString());
	}

	@Test
	public void hashCodeEqualsTest() {
		String employeeMessage = "employee";
		AdminDtoOut adminDtoOut = buildAdminDtoOut(employeeMessage);
		AdminDtoOut adminDtoOut1 = buildAdminDtoOut(employeeMessage);
		Object obj = new Object();
		assertNotEquals(adminDtoOut, obj);
		assertEquals(adminDtoOut, adminDtoOut);
		assertEquals(adminDtoOut, adminDtoOut1);
		assertEquals(false, adminDtoOut.equals(null));
		assertEquals(adminDtoOut.hashCode(), adminDtoOut1.hashCode());

	}

	public AdminDtoOut buildAdminDtoOut(String employeeMessage) {
		AdminDtoOut adminDtoOut = new AdminDtoOut();
		adminDtoOut.setEmployeeMessage(employeeMessage);
		return adminDtoOut;
	}
}
