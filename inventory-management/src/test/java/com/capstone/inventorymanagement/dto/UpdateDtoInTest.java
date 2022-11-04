package com.capstone.inventorymanagement.dto;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.capstone.inventorymanagement.domain.User;

public class UpdateDtoInTest {
	@Test
	public void updateDtoIntest() {
		UpdateDtoIn updateDtoIn = new UpdateDtoIn();

		int userId = 6;
		String firstName = "firstname";
		String lastName = "lastName";
		String dateOfBirth = "daateOfBirth";
		String password = "password";
		String designation = "designation";
		String dateOfJoining = "dateOfJoining";
		String role = "role";
		String dateOfExit = "dateOfExit";
		String location = "location";

		updateDtoIn.setFirstName(firstName);
		updateDtoIn.setLastName(lastName);
		updateDtoIn.setDateOfBirth(dateOfBirth);
		updateDtoIn.setDateOfJoining(dateOfJoining);
		updateDtoIn.setPassword(password);
		updateDtoIn.setDesignation(designation);
		updateDtoIn.setUserId(userId);
		updateDtoIn.setRole(role);
		updateDtoIn.setDateOfExit(dateOfExit);
		updateDtoIn.setLocation(location);

		assertEquals(firstName, updateDtoIn.getFirstName());
		assertEquals(lastName, updateDtoIn.getLastName());
		assertEquals(password, updateDtoIn.getPassword());
		assertEquals(userId, updateDtoIn.getUserId());
		assertEquals(designation, updateDtoIn.getDesignation());
		assertEquals(dateOfJoining, updateDtoIn.getDateOfJoining());
		assertEquals(dateOfBirth, updateDtoIn.getDateOfBirth());
		assertEquals(role, updateDtoIn.getRole());
		assertEquals(dateOfExit, updateDtoIn.getDateOfExit());
		assertEquals(location, updateDtoIn.getLocation());
	}

	@Test
	public void testGettersAndSettersUpdateEmployee() {
		UpdateDtoIn updateDtoIn = new UpdateDtoIn();

		assertNull(updateDtoIn.getPassword());
		String password = "password";
		updateDtoIn.setPassword(password);
		assertEquals(password, updateDtoIn.getPassword());

		assertNull(updateDtoIn.getDesignation());
		String designation = "designation";
		updateDtoIn.setDesignation(designation);
		assertEquals(designation, updateDtoIn.getDesignation());

		assertNull(updateDtoIn.getDateOfBirth());
		String dateOfBirth = "dateOfBirth";
		updateDtoIn.setDateOfBirth(dateOfBirth);
		assertEquals(dateOfBirth, updateDtoIn.getDateOfBirth());

		assertNull(updateDtoIn.getDateOfJoining());
		String dateOfJoining = "dateOfJoining";
		updateDtoIn.setDateOfJoining(dateOfJoining);
		assertEquals(dateOfJoining, updateDtoIn.getDateOfJoining());

		assertNull(updateDtoIn.getUserId());
		int userId = 6;
		updateDtoIn.setUserId(userId);
		assertEquals(userId, updateDtoIn.getUserId());

		assertNull(updateDtoIn.getFirstName());
		String firstName = "firstName";
		updateDtoIn.setFirstName(firstName);
		assertEquals(firstName, updateDtoIn.getFirstName());

		assertNull(updateDtoIn.getLastName());
		String lastName = "lastName";
		updateDtoIn.setLastName(lastName);
		assertEquals(lastName, updateDtoIn.getLastName());

		assertNull(updateDtoIn.getRole());
		String role = "role";
		updateDtoIn.setRole(role);
		assertEquals(role, updateDtoIn.getRole());

		assertNull(updateDtoIn.getLocation());
		String location = "location";
		updateDtoIn.setLocation(location);
		assertEquals(location, updateDtoIn.getLocation());

		assertNull(updateDtoIn.getDateOfExit());
		String dateOfExit = "dateOfExit";
		updateDtoIn.setDateOfExit(dateOfExit);
		assertEquals(dateOfExit, updateDtoIn.getDateOfExit());
	}

	@Test
	public void testToStringUpdateEmployee() {

		int userId = 6;
		String firstName = "firstname";
		String lastName = "lastName";
		String dateOfBirth = "daateOfBirth";
		String password = "password";
		String designation = "designation";
		String dateOfJoining = "dateOfJoining";
		String role = "role";
		String dateOfExit = "dateOfExit";
		String location = "location";

		UpdateDtoIn updateDtoIn = buildUpdateDtoIn(userId, firstName,
				lastName, dateOfBirth, password, designation,
				dateOfJoining, role, dateOfExit, location);
		assertNotNull(updateDtoIn.toString());
		System.out.println(updateDtoIn.toString());
	}

	@Test
	public void testEqualsAndHashCode() {
		User user = new User();
		int userId = 6;
		String firstName = "firstname";
		String lastName = "lastName";
		String dateOfBirth = "daateOfBirth";
		String password = "password";
		String designation = "designation";
		String dateOfJoining = "dateOfJoining";
		String role = "role";
		String dateOfExit = "dateOfExit";
		String location = "location";

		UpdateDtoIn updateDtoIn = buildUpdateDtoIn(userId, firstName,
				lastName, dateOfBirth, password, designation,
				dateOfJoining, role, dateOfExit, location);
		UpdateDtoIn updateDtoIn1 = buildUpdateDtoIn(userId, firstName,
				lastName, dateOfBirth, password, designation,
				dateOfJoining, role, dateOfExit, location);
		Object obj = new Object();
		assertEquals(designation, updateDtoIn.getDesignation());
		assertNotEquals(updateDtoIn, obj);
		assertEquals(updateDtoIn, updateDtoIn1);
		assertEquals(updateDtoIn, updateDtoIn);
		assertEquals(false, updateDtoIn.equals(null));
		assertEquals(false, updateDtoIn.equals(user));
		System.out.println(updateDtoIn.toString().hashCode());
		System.out.println(updateDtoIn1.toString().hashCode());
		assertEquals(updateDtoIn.hashCode(), updateDtoIn1.hashCode());

		updateDtoIn1 = buildUpdateDtoIn(userId, firstName + " ",
				lastName, dateOfBirth, password, designation,
				dateOfJoining, role, dateOfExit, location);
		assertNotEquals(updateDtoIn.hashCode(),
				updateDtoIn1.hashCode());
		updateDtoIn1 = buildUpdateDtoIn(userId, firstName, lastName,
				dateOfBirth = " ", password, designation,
				dateOfJoining, role, dateOfExit, location);
		assertNotEquals(updateDtoIn.hashCode(),
				updateDtoIn1.hashCode());
		updateDtoIn1 = buildUpdateDtoIn(userId, firstName, lastName,
				dateOfBirth, password + " ", designation,
				dateOfJoining, role, dateOfExit, location);
		assertNotEquals(updateDtoIn.hashCode(),
				updateDtoIn1.hashCode());
		updateDtoIn1 = buildUpdateDtoIn(userId, firstName,
				lastName = " ", dateOfBirth, password, designation,
				dateOfJoining, role, dateOfExit, location);
		assertNotEquals(updateDtoIn.hashCode(),
				updateDtoIn1.hashCode());
		updateDtoIn1 = buildUpdateDtoIn(userId, firstName + " ",
				lastName, dateOfBirth, password, designation = " ",
				dateOfJoining, role, dateOfExit, location);
		assertNotEquals(updateDtoIn.hashCode(),
				updateDtoIn1.hashCode());
	}

	public UpdateDtoIn buildUpdateDtoIn(int userId, String firstName,
			String lastName, String dateOfBirth, String password,
			String designation, String dateOfJoining, String role,
			String dateOfExit, String location) {
		UpdateDtoIn updateDtoIn = new UpdateDtoIn();
		updateDtoIn.setUserId(userId);
		updateDtoIn.setFirstName(firstName);
		updateDtoIn.setLastName(lastName);
		updateDtoIn.setDateOfBirth(dateOfBirth);
		updateDtoIn.setPassword(password);
		updateDtoIn.setDesignation(designation);
		updateDtoIn.setDateOfJoining(dateOfJoining);
		updateDtoIn.setRole(role);
		updateDtoIn.setDateOfExit(dateOfExit);
		updateDtoIn.setLocation(location);
		return updateDtoIn;

	}

}
