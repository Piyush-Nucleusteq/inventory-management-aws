package com.capstone.inventorymanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.capstone.inventorymanagement.controller.AdminController;
import com.capstone.inventorymanagement.domain.User;
import com.capstone.inventorymanagement.dto.AdminDtoOut;
import com.capstone.inventorymanagement.dto.UpdateDtoIn;
import com.capstone.inventorymanagement.dto.UserDto;
import com.capstone.inventorymanagement.exception.NotFoundException;
import com.capstone.inventorymanagement.exception.RecordAlreadyExistException;
import com.capstone.inventorymanagement.repository.UserRepository;

public class AdminServiceTest {
	@Mock
	private UserRepository userRepository;
	@Mock
	AdminController adminController;
	@Mock
	AdminService adminService;
	@InjectMocks
	AdminServiceImpl adminServiceImpl;
	
	@DisplayName("JUnit test for addEmployee method")
    @Test
    public void givenEmployeeObject_whenSaveEmployee_thenReturnEmployeeObject() throws RecordAlreadyExistException{
    	MockitoAnnotations.openMocks(this);
    	int userId = 6;
        String employeeId = "N0011";
        String firstName = "piyush";
        String lastName = "raghuwanshi";
        String email ="piyush@gmail.com";
        String dateOfBirth ="28/09/2000";
        String phoneNumber = "7232890902";
        String password = "piyush";
        String designation = "developer";
        String dateOfJoining = "11/05/2022";
        String role = "Admin";
        String dateOfExit = "dateOfExit";
        String location = "location";
        
       UserDto userDto = buildUserDto(userId, employeeId,firstName,lastName,email,dateOfBirth,phoneNumber,password,designation,dateOfJoining,role,dateOfExit,location);
       AdminDtoOut adminDtoOut = new AdminDtoOut();
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
        adminDtoOut.setEmployeeMessage("Employee added successfully");
    	Mockito.when(userRepository.save(user)).thenReturn(user);       
        assertEquals(adminDtoOut,adminServiceImpl.addEmployee(userDto));
    }
	@Test
    public void givenEmployeeObject_whenSaveEmployee_thenReturnEmployeeObjectNegativeEmail() throws RecordAlreadyExistException{
    	MockitoAnnotations.openMocks(this);
    	int userId = 6;
        String employeeId = "N0011";
        String firstName = "piyush";
        String lastName = "raghuwanshi";
        String email ="piyush@gmail.com";
        String dateOfBirth ="28/09/2000";
        String phoneNumber = "7232890902";
        String password = "piyush";
        String designation = "developer";
        String dateOfJoining = "11/05/2022";
        String role = "Admin";
        String dateOfExit = "dateOfExit";
        String location = "location";
        
       UserDto userDto = buildUserDto(userId, employeeId,firstName,lastName,email,dateOfBirth,phoneNumber,password,designation,dateOfJoining,role,dateOfExit,location);
       AdminDtoOut adminDtoOut = new AdminDtoOut();
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
        adminDtoOut.setEmployeeMessage("Email Already Exist");
    	Mockito.when(userRepository.findByEmail(email)).thenReturn(Optional.of(user)); 
    	RecordAlreadyExistException recordAlreadyExistException = assertThrows(RecordAlreadyExistException.class,
    			()-> adminServiceImpl.addEmployee(userDto));
    	assertEquals(adminDtoOut.getEmployeeMessage(), recordAlreadyExistException.getMessage());
        
    }
	@Test
    public void givenEmployeeObject_whenSaveEmployee_thenReturnEmployeeObjectNegativeEmployee() throws RecordAlreadyExistException{
    	MockitoAnnotations.openMocks(this);
    	int userId = 6;
        String employeeId = "N0011";
        String firstName = "piyush";
        String lastName = "raghuwanshi";
        String email ="piyush@gmail.com";
        String dateOfBirth ="28/09/2000";
        String phoneNumber = "7232890902";
        String password = "piyush";
        String designation = "developer";
        String dateOfJoining = "11/05/2022";
        String role = "Admin";
        String dateOfExit = "dateOfExit";
        String location = "location";
        
       UserDto userDto = buildUserDto(userId, employeeId,firstName,lastName,email,dateOfBirth,phoneNumber,password,designation,dateOfJoining,role,dateOfExit,location);
       AdminDtoOut adminDtoOut = new AdminDtoOut();
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
        adminDtoOut.setEmployeeMessage("Employee Id Already Exist");
    	Mockito.when(userRepository.findByEmployeeId(employeeId)).thenReturn(Optional.of(user)); 
    	RecordAlreadyExistException recordAlreadyExistException = assertThrows(RecordAlreadyExistException.class,
    			()-> adminServiceImpl.addEmployee(userDto));
    	assertEquals(adminDtoOut.getEmployeeMessage(), recordAlreadyExistException.getMessage());
        
    }
	@Test
    public void givenEmployeeObject_whenSaveEmployee_thenReturnEmployeeObjectNegativePhone() throws RecordAlreadyExistException{
    	MockitoAnnotations.openMocks(this);
    	int userId = 6;
        String employeeId = "N0011";
        String firstName = "piyush";
        String lastName = "raghuwanshi";
        String email ="piyush@gmail.com";
        String dateOfBirth ="28/09/2000";
        String phoneNumber = "7232890902";
        String password = "piyush";
        String designation = "developer";
        String dateOfJoining = "11/05/2022";
        String role = "Admin";
        String dateOfExit = "dateOfExit";
        String location = "location";
        
       UserDto userDto = buildUserDto(userId, employeeId,firstName,lastName,email,dateOfBirth,phoneNumber,password,designation,dateOfJoining,role,dateOfExit,location);
       AdminDtoOut adminDtoOut = new AdminDtoOut();
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
        adminDtoOut.setEmployeeMessage("Phone Number Already Exist");
    	Mockito.when(userRepository.findByPhoneNumber(phoneNumber)).thenReturn(Optional.of(user)); 
    	RecordAlreadyExistException recordAlreadyExistException = assertThrows(RecordAlreadyExistException.class,
    			()-> adminServiceImpl.addEmployee(userDto));
    	assertEquals(adminDtoOut.getEmployeeMessage(), recordAlreadyExistException.getMessage());
        
    }
	@Test
    public void updateUserTest() throws NotFoundException {
        MockitoAnnotations.openMocks(this);
        String passwordUpdate = "Piyush28*";
        int userId = 53;
        String firstName = "piyush";
        String lastName = "raghuwanshi";
        String dateOfBirth ="28/09/2000";
        String password = "piyush";
        String designation = "developer";
        String dateOfJoining = "11/05/2022";
        String role = "Admin";
        String dateOfExit = "dateOfExit";
        String location = "location";
        AdminDtoOut adminDtoOut = new AdminDtoOut();
        UpdateDtoIn updateDtoIn = new UpdateDtoIn(userId,firstName,lastName,
                role,dateOfBirth,password,designation,dateOfJoining,dateOfExit,location);
        User user = new User();
        user.setUserId(updateDtoIn.getUserId());
        user.setFirstName(updateDtoIn.getFirstName());
        user.setLastName(updateDtoIn.getLastName());
        user.setDateOfBirth(updateDtoIn.getDateOfBirth());
        user.setDateOfJoining(updateDtoIn.getDateOfJoining());
        user.setPassword(updateDtoIn.getPassword());
        user.setDesignation(updateDtoIn.getDesignation());
        user.setRole(updateDtoIn.getRole());
        user.setDateOfExit(updateDtoIn.getDateOfExit());
        user.setLocation(updateDtoIn.getLocation()); 
        Optional<User> optUser = Optional.of(user);
        when(userRepository.findById(53)).thenReturn(optUser);
        user.setPassword(passwordUpdate);
        adminDtoOut.setEmployeeMessage("Employee Updated successfully");
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(adminDtoOut, adminServiceImpl.updateEmployee(updateDtoIn));
    }
	@Test
    public void updateUserTestEmployee() throws NotFoundException {
        MockitoAnnotations.openMocks(this);
        String passwordUpdate = "Piyush28*";
        int userId = 53;
        String firstName = "piyush";
        String lastName = "raghuwanshi";
        String dateOfBirth ="28/09/2000";
        String password = "piyush";
        String designation = "developer";
        String dateOfJoining = "11/05/2022";
        String role = "Admin";
        String dateOfExit = "dateOfExit";
        String location = "location";
        AdminDtoOut adminDtoOut = new AdminDtoOut();
        UpdateDtoIn updateDtoIn = new UpdateDtoIn(userId,firstName,lastName,
                role,dateOfBirth,password,designation,dateOfJoining,dateOfExit,location);
        User user = new User();
        user.setUserId(updateDtoIn.getUserId());
        user.setFirstName(updateDtoIn.getFirstName());
        user.setLastName(updateDtoIn.getLastName());
        user.setDateOfBirth(updateDtoIn.getDateOfBirth());
        user.setDateOfJoining(updateDtoIn.getDateOfJoining());
        user.setPassword(updateDtoIn.getPassword());
        user.setDesignation(updateDtoIn.getDesignation());
        user.setRole(updateDtoIn.getRole());
        user.setDateOfExit(updateDtoIn.getDateOfExit());
        user.setLocation(updateDtoIn.getLocation()); 
        user.setPassword(passwordUpdate);
        adminDtoOut.setEmployeeMessage("Employee Not found");
        Optional<User> optionalUser = Optional.empty();
        when(userRepository.findById(userId)).thenReturn(optionalUser);
        NotFoundException notFoundException = assertThrows(NotFoundException.class,
    			()-> adminServiceImpl.updateEmployee(updateDtoIn));
    	assertEquals(adminDtoOut.getEmployeeMessage(), notFoundException.getMessage());
    }
	@Test
	public void getAllEmployeeTest() {
		 MockitoAnnotations.openMocks(this);
		int userId = 6;
    	String employeeId = "N0011";
        String firstName = "firstname";
        String lastName = "lastName";
        String email ="email@nucleusteq.com";
        String dateOfBirth ="dateOfBirth";
        String phoneNumber = "7232890902";
        String password = "password";
        String designation = "designation";
        String dateOfJoining = "dateOfJoining";
        String role = "role";
        String dateOfExit = "dateOfExit";
        String location = "location";
        String createdAt = "createdAt";
        String updatedAt = "updatedAt";
	            
	      
        User user1 = buildUser(userId, employeeId,firstName,lastName,email,dateOfBirth,phoneNumber,password,designation,dateOfJoining,role,dateOfExit,location,createdAt,updatedAt);

	    List<User> employeeList = new ArrayList<User>();
	    employeeList.add(user1);
	    when(userRepository.findAll()).thenReturn(employeeList);
        assertEquals(employeeList, adminServiceImpl.getAllEmployee());
}
	@Test
	public void searchEmployeeDetails() {
		
		MockitoAnnotations.openMocks(this);
		int userId = 6;
        String employeeId = "N0011";
        String firstName = "piyush";
        String lastName = "raghuwanshi";
        String email ="piyush@gmail.com";
        String dateOfBirth ="28/09/2000";
        String phoneNumber = "7232890902";
        String password = "piyush";
        String designation = "developer";
        String dateOfJoining = "11/05/2022";
        String role = "Admin";
        String dateOfExit = "dateOfExit";
        String location = "location";
        String createdAt = "createdAt";
        String updatedAt = "updatedAt";
        
       UserDto userDto1 = buildUserDto(userId, employeeId,firstName,lastName,email,dateOfBirth,phoneNumber,password,designation,dateOfJoining,role,dateOfExit,location);
      
       User user = buildUser(userId, employeeId,firstName,lastName,email,dateOfBirth,phoneNumber,password,designation,dateOfJoining,role,dateOfExit,location,createdAt,updatedAt);
       
	  	Optional<User> user1 = Optional.of(user);
	 //   User entity = user1.get();
	    UserDto userDto = new UserDto();
        userDto.setEmployeeId(user.getEmployeeId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setDateOfBirth(user.getDateOfBirth());
        userDto.setDateOfJoining(user.getDateOfJoining());
        userDto.setPassword(user.getPassword());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setDesignation(user.getDesignation());
        userDto.setRole(user.getRole());
        userDto.setDateOfExit(user.getDateOfExit());
        userDto.setLocation(user.getLocation());
        userDto.setUserId(user.getUserId());	  
        System.out.println("optional "+ user);
	  
       when(userRepository.findByEmployeeId(employeeId)).thenReturn(user1);
     assertEquals(userDto1,adminServiceImpl.getSearchEmployee(employeeId));
	}
	public User buildUser(int userId,String employeeId,String firstName,String lastName,String email,String dateOfBirth,String phoneNumber,String password,String designation,String dateOfJoining,String role,String dateOfExit,String location,String createdAt,String updatedAt) {
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
	 public UserDto buildUserDto(int userId,String employeeId,String firstName,String lastName,String email,String dateOfBirth,String phoneNumber,String password,String designation,String dateOfJoining,String role,String dateOfExit,String location) {
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
