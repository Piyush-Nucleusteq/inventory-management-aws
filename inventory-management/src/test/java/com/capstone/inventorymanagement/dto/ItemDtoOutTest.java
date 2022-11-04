package com.capstone.inventorymanagement.dto;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class ItemDtoOutTest {

	@Test
	public void itemDtoOutTest() {
		ItemDtoOut adminDtoOut = new ItemDtoOut();
		String message = "employee";
		adminDtoOut.setMessage(message);
		assertEquals(message, adminDtoOut.getMessage());

	}

	@Test
	public void toStringTEst() {
		String message = "employee";
		ItemDtoOut adminDtoOut = builItemDtoOut(message);
		assertNotNull(adminDtoOut.toString());
	}

	@Test
	public void hashCodeEqualsTest() {
		String message = "employee";
		ItemDtoOut adminDtoOut = builItemDtoOut(message);
		ItemDtoOut adminDtoOut1 = builItemDtoOut(message);
		Object obj = new Object();
		assertNotEquals(adminDtoOut, obj);
		assertEquals(adminDtoOut, adminDtoOut);
		assertEquals(adminDtoOut, adminDtoOut1);
		assertEquals(false, adminDtoOut.equals(null));
		assertEquals(adminDtoOut.hashCode(), adminDtoOut1.hashCode());

	}

	public ItemDtoOut builItemDtoOut(String message) {
		ItemDtoOut adminDtoOut = new ItemDtoOut();
		adminDtoOut.setMessage(message);
		return adminDtoOut;
	}

}
