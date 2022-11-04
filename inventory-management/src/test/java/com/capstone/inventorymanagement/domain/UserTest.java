package com.capstone.inventorymanagement.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.capstone.inventorymanagement.dto.UserDto;

public class UserTest {
	/**
	 * To test the user class
	 */
	@Test
	public void userTest() {
		User user = new User();

		int userId = 6;
		String employeeId = "N0011";
		String firstName = "piyush";
		String lastName = "raghuwanshi";
		String email = "piyush@gmail.com";
		String dateOfBirth = "28/09/2000";
		String phoneNumber = "7232890902";
		String password = "piyush";
		String designation = "developer";
		String dateOfJoining = "11/05/2022";
		String role = "Admin";
		String dateOfExit = "dateOfExit";
		String location = "location";
		boolean firstLogin = false;

		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setDateOfBirth(dateOfBirth);
		user.setDateOfJoining(dateOfJoining);
		user.setEmployeeId(employeeId);
		user.setPassword(password);
		user.setPhoneNumber(phoneNumber);
		user.setDesignation(designation);
		user.setUserId(userId);
		user.setRole(role);
		user.setDateOfExit(dateOfExit);
		user.setLocation(location);
		user.setFirstLogin(firstLogin);

		assertEquals(email, user.getEmail());
		assertEquals(firstName, user.getFirstName());
		assertEquals(lastName, user.getLastName());
		assertEquals(password, user.getPassword());
		assertEquals(userId, user.getUserId());
		assertEquals(employeeId, user.getEmployeeId());
		assertEquals(phoneNumber, user.getPhoneNumber());
		assertEquals(designation, user.getDesignation());
		assertEquals(dateOfJoining, user.getDateOfJoining());
		assertEquals(dateOfBirth, user.getDateOfBirth());
		assertEquals(role, user.getRole());
		assertEquals(dateOfExit, user.getDateOfExit());
		assertEquals(location, user.getLocation());
		assertEquals(firstLogin, user.isFirstLogin());
	}

	@Test
	public void testGettersAndSetters() {
		User userDto = new User();

		assertNull(userDto.getEmail());
		String email = "email";
		userDto.setEmail(email);
		assertEquals(email, userDto.getEmail());

		assertNull(userDto.getPassword());
		String password = "password";
		userDto.setPassword(password);
		assertEquals(password, userDto.getPassword());

		assertNull(userDto.getPhoneNumber());
		String phoneNumber = "phoneNumber";
		userDto.setPhoneNumber(phoneNumber);
		assertEquals(phoneNumber, userDto.getPhoneNumber());

		assertNull(userDto.getDesignation());
		String designation = "designation";
		userDto.setDesignation(designation);
		assertEquals(designation, userDto.getDesignation());

		assertNull(userDto.getDateOfBirth());
		String dateOfBirth = "dateOfBirth";
		userDto.setDateOfBirth(dateOfBirth);
		assertEquals(dateOfBirth, userDto.getDateOfBirth());

		assertNull(userDto.getDateOfJoining());
		String dateOfJoining = "dateOfJoining";
		userDto.setDateOfJoining(dateOfJoining);
		assertEquals(dateOfJoining, userDto.getDateOfJoining());

		assertNull(userDto.getEmployeeId());
		String employeeId = "N0011";
		userDto.setEmployeeId(employeeId);
		assertEquals(employeeId, userDto.getEmployeeId());

		assertNull(userDto.getUserId());
		int userId = 6;
		userDto.setUserId(userId);
		assertEquals(userId, userDto.getUserId());

		assertNull(userDto.getFirstName());
		String firstName = "firstName";
		userDto.setFirstName(firstName);
		assertEquals(firstName, userDto.getFirstName());

		assertNull(userDto.getLastName());
		String lastName = "lastName";
		userDto.setLastName(lastName);
		assertEquals(lastName, userDto.getLastName());

		assertNull(userDto.getRole());
		String role = "role";
		userDto.setRole(role);
		assertEquals(role, userDto.getRole());

	}

	@Test
	public void testToString() {

		int userId = 6;
		String employeeId = "N0011";
		String firstName = "firstname";
		String lastName = "lastName";
		String email = "email@email.com";
		String dateOfBirth = "daateOfBirth";
		String phoneNumber = "phoneNumber";
		String password = "password";
		String designation = "designation";
		String dateOfJoining = "dateOfJoining";
		String role = "role";
		String dateOfExit = "dateOfExit";
		String location = "location";
		String createdAt = "createdAt";
		String updatedAt = "updatedAt";

		User user = buildUser(userId, employeeId, firstName, lastName,
				email, dateOfBirth, phoneNumber, password,
				designation, dateOfJoining, role, dateOfExit,
				location, createdAt, updatedAt);
		assertNotNull(user.toString());
		System.out.println(user.toString());
	}

	@Test
	public void testEqualsAndHashCode() {

		User user = new User();

		int userId = 6;
		String employeeId = "N0011";
		String firstName = "firstname";
		String lastName = "lastName";
		String email = "email@email.com";
		String dateOfBirth = "daateOfBirth";
		String phoneNumber = "phoneNumber";
		String password = "password";
		String designation = "designation";
		String dateOfJoining = "dateOfJoining";
		String role = "role";
		String dateOfExit = "dateOfExit";
		String location = "location";
		String createdAt = "createdAt";
		String updatedAt = "updatedAt";

		User user1 = buildUser(userId, employeeId, firstName,
				lastName, email, dateOfBirth, phoneNumber, password,
				designation, dateOfJoining, role, dateOfExit,
				location, createdAt, updatedAt);
		User user2 = buildUser(userId, employeeId, firstName,
				lastName, email, dateOfBirth, phoneNumber, password,
				designation, dateOfJoining, role, dateOfExit,
				location, createdAt, updatedAt);

		assertEquals(user1, user2);
		assertEquals(user1, user1);
		assertEquals(false, user1.equals(null));
		assertEquals(false, user1.equals(user));
		System.out.println(user1.toString().hashCode());
		System.out.println(user1.toString().hashCode());
		assertEquals(user1.hashCode(), user2.hashCode());
	}

	public User buildUser(int userId, String employeeId,
			String firstName, String lastName, String email,
			String dateOfBirth, String phoneNumber, String password,
			String designation, String dateOfJoining, String role,
			String dateOfExit, String location, String createdAt,
			String updatedAt) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setDateOfBirth(dateOfBirth);
		user.setDateOfJoining(dateOfJoining);
		user.setEmployeeId(employeeId);
		user.setPassword(password);
		user.setPhoneNumber(phoneNumber);
		user.setDesignation(designation);
		user.setUserId(userId);
		user.setRole(role);
		user.setDateOfExit(dateOfExit);
		user.setLocation(location);
		user.setCreatedAt(createdAt);
		user.setUpdatedAt(updatedAt);
		return user;
	}
}
