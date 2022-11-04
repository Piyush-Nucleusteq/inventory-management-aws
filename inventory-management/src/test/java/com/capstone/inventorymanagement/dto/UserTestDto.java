package com.capstone.inventorymanagement.dto;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.jws.soap.SOAPBinding.Use;

import org.junit.jupiter.api.Test;

import com.capstone.inventorymanagement.domain.User;

public class UserTestDto {
	/**
	 * To test the userDto class.
	 */
	@Test
	public void userDtoTest() {
		UserDto user = new UserDto();

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

	}

	@Test
	public void testGettersAndSetters() {
		UserDto userDto = new UserDto();

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

		assertNull(userDto.getLocation());
		String location = "location";
		userDto.setLocation(location);
		assertEquals(location, userDto.getLocation());

		assertNull(userDto.getDateOfExit());
		String dateOfExit = "dateOfExit";
		userDto.setDateOfExit(dateOfExit);
		assertEquals(dateOfExit, userDto.getDateOfExit());
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

		UserDto userDto = buildUserDto(userId, employeeId, firstName,
				lastName, email, dateOfBirth, phoneNumber, password,
				designation, dateOfJoining, role, dateOfExit,
				location);
		assertNotNull(userDto.toString());
		System.out.println(userDto.toString());
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

		UserDto userDto = buildUserDto(userId, employeeId, firstName,
				lastName, email, dateOfBirth, phoneNumber, password,
				designation, dateOfJoining, role, dateOfExit,
				location);
		UserDto userDto1 = buildUserDto(userId, employeeId, firstName,
				lastName, email, dateOfBirth, phoneNumber, password,
				designation, dateOfJoining, role, dateOfExit,
				location);
		Object obj = new Object();
		assertEquals(email, userDto.getEmail());
		assertNotEquals(userDto, obj);
		assertEquals(userDto, userDto1);
		assertEquals(userDto, userDto);
		assertEquals(false, userDto.equals(null));
		assertEquals(false, userDto.equals(user));
		System.out.println(userDto.toString().hashCode());
		System.out.println(userDto1.toString().hashCode());
		assertEquals(userDto.hashCode(), userDto1.hashCode());

		userDto1 = buildUserDto(userId, employeeId, firstName + " ",
				lastName, email, dateOfBirth, phoneNumber, password,
				designation, dateOfJoining, role, dateOfExit,
				location);
		assertNotEquals(userDto.hashCode(), userDto1.hashCode());
		userDto1 = buildUserDto(userId, employeeId, firstName,
				lastName + " ", email, dateOfBirth, phoneNumber,
				password, designation, dateOfJoining, role,
				dateOfExit, location);
		assertNotEquals(userDto.hashCode(), userDto1.hashCode());
		userDto1 = buildUserDto(userId, employeeId, firstName,
				lastName, email + " ", dateOfBirth, phoneNumber,
				password, designation, dateOfJoining, role,
				dateOfExit, location);
		assertNotEquals(userDto.hashCode(), userDto1.hashCode());
		userDto1 = buildUserDto(userId, employeeId, firstName,
				lastName, email, dateOfBirth + " ", phoneNumber,
				password, designation, dateOfJoining, role,
				dateOfExit, location);
		assertNotEquals(userDto.hashCode(), userDto1.hashCode());
		userDto1 = buildUserDto(userId, employeeId, firstName,
				lastName, email, dateOfBirth, phoneNumber + " ",
				password, designation, dateOfJoining, role,
				dateOfExit, location);
		assertNotEquals(userDto.hashCode(), userDto1.hashCode());
		userDto1 = buildUserDto(userId, employeeId, firstName,
				lastName, email, dateOfBirth, phoneNumber,
				password = " ", designation, dateOfJoining, role,
				dateOfExit, location);
		assertNotEquals(userDto.hashCode(), userDto1.hashCode());
	}

	public UserDto buildUserDto(int userId, String employeeId,
			String firstName, String lastName, String email,
			String dateOfBirth, String phoneNumber, String password,
			String designation, String dateOfJoining, String role,
			String dateOfExit, String location) {
		UserDto userDto = new UserDto();
		userDto.setUserId(userId);
		userDto.setEmployeeId(employeeId);
		userDto.setFirstName(firstName);
		userDto.setLastName(lastName);
		userDto.setEmail(email);
		userDto.setDateOfBirth(dateOfBirth);
		userDto.setPhoneNumber(phoneNumber);
		userDto.setPassword(password);
		userDto.setDesignation(designation);
		userDto.setDateOfJoining(dateOfJoining);
		userDto.setRole(role);
		userDto.setDateOfExit(dateOfExit);
		userDto.setLocation(location);
		return userDto;

	}
}
