package com.capstone.inventorymanagement.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capstone.inventorymanagement.domain.User;
import com.capstone.inventorymanagement.dto.AdminDtoOut;
import com.capstone.inventorymanagement.dto.UpdateDtoIn;
import com.capstone.inventorymanagement.dto.UserDto;
import com.capstone.inventorymanagement.repository.UserRepository;
import com.capstone.inventorymanagement.service.AdminService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class AdminControllerTest {

	@Mock
	private AdminService adminService;

	@Mock
	private UserRepository userRepository;

	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	private AdminController adminController;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(adminController)
				.build();
	}

	@Test
	public void addEmployeeTest() throws Exception {
		MockitoAnnotations.openMocks(this);
		int userId = 6;
		String employeeId = "N0011";
		String firstName = "firstname";
		String lastName = "lastName";
		String email = "email@nucleusteq.com";
		String dateOfBirth = "dateOfBirth";
		String phoneNumber = "7232890902";
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

		AdminDtoOut adminDtoOut = new AdminDtoOut();
		adminDtoOut.setEmployeeMessage("Employee added successfully");
		Mockito.when(adminService.addEmployee(userDto))
				.thenReturn(adminDtoOut);

		ObjectMapper objectMapper = new ObjectMapper();
		String inputJSON = objectMapper.writeValueAsString(userDto);

		MvcResult mvcResult = this.mockMvc.perform(post("/employee")
				.contentType(MediaType.APPLICATION_JSON)
				.content(inputJSON)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

	@Test
	public void updateEmployeeTest() throws Exception {
		MockitoAnnotations.openMocks(this);
		int userId = 6;
		String firstName = "firstname";
		String lastName = "lastName";
		String dateOfBirth = "dateOfBirth";
		String password = "password";
		String designation = "designation";
		String dateOfJoining = "dateOfJoining";
		String role = "role";
		String dateOfExit = "dateOfExit";
		String location = "location";

		UpdateDtoIn updateDtoIn = new UpdateDtoIn(userId, firstName,
				lastName, dateOfBirth, password, designation,
				dateOfJoining, role, dateOfExit, location);

		AdminDtoOut adminDtoOut = new AdminDtoOut();
		adminDtoOut
				.setEmployeeMessage("Employee Updated successfully");
		Mockito.when(adminService.updateEmployee(updateDtoIn))
				.thenReturn(adminDtoOut);

		ObjectMapper objectMapper = new ObjectMapper();
		String inputJSON = objectMapper
				.writeValueAsString(updateDtoIn);

		MvcResult mvcResult = this.mockMvc.perform(put("/employee")
				.contentType(MediaType.APPLICATION_JSON)
				.content(inputJSON)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(HttpStatus.OK.value(), status);
	}

	@Test
	public void getallEmployeeTest() throws Exception {

		int userId = 6;
		String employeeId = "N0011";
		String firstName = "firstname";
		String lastName = "lastName";
		String email = "email@nucleusteq.com";
		String dateOfBirth = "dateOfBirth";
		String phoneNumber = "7232890902";
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

		List<User> employeeList = new ArrayList<User>();
		employeeList.add(user1);
		when(adminService.getAllEmployee()).thenReturn(employeeList);
		MvcResult mvcResult = this.mockMvc.perform(get("/employee"))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(HttpStatus.OK.value(), status);

	}

	@Test
	public void findEmployee() throws Exception {
		UserDto userEntity = new UserDto();
		String employeeId = "N0011";
		String firstName = "firstname";
		String lastName = "lastName";
		String email = "email@nucleusteq.com";
		String dateOfBirth = "dateOfBirth";
		String phoneNumber = "7232890902";
		String designation = "designation";
		String dateOfJoining = "dateOfJoining";
		String role = "role";
		String dateOfExit = "dateOfExit";
		String location = "location";
		userEntity.setFirstName(firstName);
		userEntity.setLastName(lastName);
		userEntity.setEmployeeId(employeeId);
		userEntity.setEmail(email);
		userEntity.setDateOfBirth(dateOfBirth);
		userEntity.setPhoneNumber(phoneNumber);
		userEntity.setDesignation(designation);
		userEntity.setDateOfJoining(dateOfJoining);
		userEntity.setDateOfExit(dateOfExit);
		userEntity.setLocation(location);
		userEntity.setRole(role);

		String inputJSON = new ObjectMapper()
				.writeValueAsString(userEntity);
		when(adminService.getSearchEmployee(employeeId))
				.thenReturn(userEntity);
		MvcResult mvcResult = this.mockMvc
				.perform(get("/searchEmployee/N0011")
						.contentType(MediaType.APPLICATION_JSON)
						.content(inputJSON))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		userEntity = adminService.getSearchEmployee(employeeId);
		assertEquals(userEntity, userEntity);
		assertNotEquals(false, userEntity);
		System.out.println("status" + status);
		assertEquals(200, status);
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
