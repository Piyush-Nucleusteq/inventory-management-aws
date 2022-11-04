package com.capstone.inventorymanagement.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capstone.inventorymanagement.dto.AdminDtoOut;
import com.capstone.inventorymanagement.dto.LoginDtoIn;
import com.capstone.inventorymanagement.dto.LoginDtoOut;
import com.capstone.inventorymanagement.dto.UserDto;
import com.capstone.inventorymanagement.exception.NotFoundException;
import com.capstone.inventorymanagement.repository.UserRepository;
import com.capstone.inventorymanagement.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

//@WebMvcTest(value= UserController.class)
//@AutoConfigureMockMvc
@MockitoSettings(strictness = Strictness.LENIENT)
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

	@Mock
	private UserService userService;

	@Autowired
	private MockMvc mockMvc;

	@Mock
	UserRepository userRepository;

	@InjectMocks
	UserController userController;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(userController)
				.build();
	}

	@Test
	public void createUsertest() throws Exception {
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
		Mockito.when(userService.createUser(userDto))
				.thenReturn("Signed Up successfully");

		ObjectMapper objectMapper = new ObjectMapper();
		String inputJSON = objectMapper.writeValueAsString(userDto);

		MvcResult mvcResult = this.mockMvc.perform(
				post("/user").contentType(MediaType.APPLICATION_JSON)
						.content(inputJSON))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

	@Test
	public void createUserNegativeTest() throws Exception {
		MockitoAnnotations.openMocks(this);
		int userId = 6;
		String employeeId = "N0011";
		String firstName = "firstname";
		String lastName = "lastName";
		String email = "email@email.com";
		String dateOfBirth = "dateOfBirth";
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
		Mockito.when(userService.createUser(userDto))
				.thenReturn(null);

		ObjectMapper objectMapper = new ObjectMapper();
		String inputJSON = objectMapper.writeValueAsString(userDto);

		MvcResult mvcResult = this.mockMvc.perform(
				post("/user").contentType(MediaType.APPLICATION_JSON)
						.content(inputJSON))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
	}

	@Test
	public void loginUserTest() throws Exception {
		MockitoAnnotations.openMocks(this);
		String email = "email@gmail.com";
		String password = "password";

		LoginDtoIn loginDtoIn = new LoginDtoIn(email, password);

		LoginDtoOut loginDtoOut = new LoginDtoOut("firstName",
				"role");

		Mockito.when(userService.loginUser(loginDtoIn))
				.thenReturn(loginDtoOut);

		ObjectMapper objectMapper = new ObjectMapper();
		String inputJSON = objectMapper
				.writeValueAsString(loginDtoIn);

		MvcResult mvcResult = this.mockMvc.perform(post("/loginUser")
				.contentType(MediaType.APPLICATION_JSON)
				.content(inputJSON)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

	@Test
	public void loginUserNegativeTest() throws Exception {
		MockitoAnnotations.openMocks(this);
		String email = "email@gmail.com";
		String password = "password";

		LoginDtoIn loginDtoIn = new LoginDtoIn(email, password);

		LoginDtoOut loginDtoOut = new LoginDtoOut(null, null);

		Mockito.when(userService.loginUser(loginDtoIn))
				.thenReturn(loginDtoOut);
		ObjectMapper objectMapper = new ObjectMapper();
		String inputJSON = objectMapper
				.writeValueAsString(loginDtoIn);
		MvcResult mvcResult = this.mockMvc.perform(post("/loginUser")
				.contentType(MediaType.APPLICATION_JSON)
				.content(inputJSON)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
	}

	@Test
	public void resetPasswordTest() throws Exception {
		MockitoAnnotations.openMocks(this);
		String email = "email@gmail.com";
		String password = "password";

		LoginDtoIn loginDtoIn = new LoginDtoIn(email, password);
		AdminDtoOut adminDtoOut = new AdminDtoOut();

		adminDtoOut.setEmployeeMessage("Password reset successfully");

		Mockito.when(userService.resetPassword(loginDtoIn))
				.thenReturn(adminDtoOut);

		ObjectMapper objectMapper = new ObjectMapper();
		String inputJSON = objectMapper
				.writeValueAsString(loginDtoIn);

		MvcResult mvcResult = this.mockMvc.perform(
				put("/reset").contentType(MediaType.APPLICATION_JSON)
						.content(inputJSON))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
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
