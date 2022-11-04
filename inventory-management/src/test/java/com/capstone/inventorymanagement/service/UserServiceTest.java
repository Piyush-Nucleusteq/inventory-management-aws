package com.capstone.inventorymanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.capstone.inventorymanagement.controller.UserController;
import com.capstone.inventorymanagement.domain.User;
import com.capstone.inventorymanagement.dto.AdminDtoOut;
import com.capstone.inventorymanagement.dto.LoginDtoIn;
import com.capstone.inventorymanagement.dto.LoginDtoOut;
import com.capstone.inventorymanagement.dto.UserDto;
import com.capstone.inventorymanagement.exception.NotFoundException;
import com.capstone.inventorymanagement.exception.RecordAlreadyExistException;
import com.capstone.inventorymanagement.exception.UnauthorizedException;
import com.capstone.inventorymanagement.repository.UserRepository;

@RunWith(SpringRunner.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;
	@InjectMocks
	private UserServiceImpl userServiceImpl;
	@Mock
	private UserService userService;
	@Mock
	UserController userController;

	


	// JUnit test for createUser method
	@DisplayName("JUnit test for saveEmployee method")
	@Test
	public void givenUserObject_whenSaveUser_thenReturnUserObject()
			throws RecordAlreadyExistException {
		MockitoAnnotations.openMocks(this);
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

		UserDto userDto = buildUserDto(userId, employeeId, firstName,
				lastName, email, dateOfBirth, phoneNumber, password,
				designation, dateOfJoining, role, dateOfExit,
				location);
		User user = new User();
		user.setEmployeeId(userDto.getEmployeeId());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setDateOfBirth(userDto.getDateOfBirth());
		user.setDateOfJoining(userDto.getDateOfJoining());
		user.setPassword(userDto.getPassword());
		user.setPhoneNumber(userDto.getPhoneNumber());
		user.setDesignation(userDto.getDesignation());
		user.setRole(userDto.getRole());
		user.setDateOfExit(userDto.getDateOfExit());
		user.setLocation(userDto.getLocation());
		Mockito.when(userRepository.save(user)).thenReturn(user);
		assertEquals("Signed Up successfully",
				userServiceImpl.createUser(userDto));
	}
//    @Test
//    public void givenUserObject_whenSaveUser_thenReturnUserObjectNegative(){
//    	MockitoAnnotations.openMocks(this);
//    	Mockito.when(userRepository.findAll().thenReturn(Stream.of(new buildUserDto(userId, employeeId,firstName,lastName,email,dateOfBirth,phoneNumber,password,designation,dateOfJoining,role,dateOfExit,location);
//).collect(Collectors.toList()));  
//        UserDto userDto1 = buildUserDto(userId, employeeId,firstName,lastName,email,dateOfBirth,phoneNumber,password,designation,dateOfJoining,role,dateOfExit,location);
//
//        assertEquals("Email or employeeid or primary contact - already exist!",userServiceImpl.createUser(userDto1));
//    }

	@Test
	public void loginUserTest() throws UnauthorizedException {
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
		String createdAt = "createdAt";
		String updatedAt = "updatedAt";
		boolean firstLogin = false;

		MockitoAnnotations.openMocks(this);
		User user = new User(userId, employeeId, role, firstName,
				lastName, email, dateOfBirth, phoneNumber, password,
				designation, dateOfJoining, dateOfExit, location,
				createdAt, updatedAt, firstLogin);
		List<User> userList = new ArrayList<User>();
		userList.add(user);

		LoginDtoOut loginDtoOut = new LoginDtoOut();
		loginDtoOut.setFirstName(user.getFirstName());
		loginDtoOut.setRole(user.getRole());

		Mockito.when(userRepository.findAll()).thenReturn(userList);
		LoginDtoIn loginDtoIn = new LoginDtoIn("piyush@gmail.com",
				"piyush");
		assertEquals(loginDtoOut,
				userServiceImpl.loginUser(loginDtoIn));
	}

	@Test
	public void loginUserNegativeTest() throws UnauthorizedException {
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
		String createdAt = "createdAt";
		String updatedAt = "updatedAt";
		boolean firstLogin = false;

		MockitoAnnotations.openMocks(this);
		User user = new User(userId, employeeId, role, firstName,
				lastName, email, dateOfBirth, phoneNumber, password,
				designation, dateOfJoining, dateOfExit, location,
				createdAt, updatedAt, firstLogin);
		List<User> userList = new ArrayList<User>();
		userList.add(user);
		LoginDtoOut loginDtoOut = new LoginDtoOut();
		loginDtoOut.setFirstName(null);
		loginDtoOut.setRole(null);
		Mockito.when(userRepository.findAll()).thenReturn(userList);
		LoginDtoIn loginDtoIn = new LoginDtoIn("email@gmail.com",
				"password");
//		assertEquals(null, userService.loginUser(loginDtoIn));
		UnauthorizedException unauthorizedException = assertThrows(
				UnauthorizedException.class,
				() -> userServiceImpl.loginUser(loginDtoIn));
		assertEquals("Invalid Credentials!",
				unauthorizedException.getMessage());

	}

	@Test
	public void resetPasswordTest() throws NotFoundException {
		MockitoAnnotations.openMocks(this);
		String passwordUpdate = "Piyush28*";

		String email = "piyush@gmail.com";

		String password = "piyush";

		AdminDtoOut adminDtoOut = new AdminDtoOut();
		LoginDtoIn loginDtoIn = new LoginDtoIn(email, password);
		User user = new User();

		user.setPassword(loginDtoIn.getPassword());
		user.setEmail(loginDtoIn.getEmail());

		Optional<User> optUser = Optional.of(user);
		when(userRepository.findByEmail(email)).thenReturn(optUser);
		user.setPassword(passwordUpdate);
		adminDtoOut.setEmployeeMessage("Password reset successfully");
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(adminDtoOut,
				userServiceImpl.resetPassword(loginDtoIn));

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
