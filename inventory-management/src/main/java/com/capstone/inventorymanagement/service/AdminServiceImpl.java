package com.capstone.inventorymanagement.service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capstone.inventorymanagement.domain.User;
import com.capstone.inventorymanagement.dto.AdminDtoOut;
import com.capstone.inventorymanagement.dto.UpdateDtoIn;
import com.capstone.inventorymanagement.dto.UserDto;
import com.capstone.inventorymanagement.exception.NotFoundException;
import com.capstone.inventorymanagement.exception.RecordAlreadyExistException;
import com.capstone.inventorymanagement.repository.UserRepository;
/**
 * @author piyush
 *
 */
@Service
public class AdminServiceImpl implements AdminService {
    /**
     * user repository reference object.
     */
    @Autowired
     private UserRepository userRepository;
    /**
     * list of all employee.
     */
    @Override
    public final List<User> getAllEmployee() {
        return userRepository.findAll();
    }
    /**
     * add employee.
     * @throws RecordAlreadyExistException.
     */
    @Override
    public final AdminDtoOut addEmployee(final
          @Valid UserDto userDto)
               throws RecordAlreadyExistException {
        AdminDtoOut adminDtoOut = new AdminDtoOut();
        if (userRepository.findByEmail(
             userDto.getEmail()).isPresent()) {
                throw new
                RecordAlreadyExistException("Email Already Exist");
           } else if (userRepository.findByEmployeeId(
                   userDto.getEmployeeId()).isPresent()) {
                 throw new
                 RecordAlreadyExistException("Employee Id Already Exist");
           } else if (userRepository.findByPhoneNumber(
                   userDto.getPhoneNumber()).isPresent()) {
             throw new
             RecordAlreadyExistException("Phone Number Already Exist");
           }
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
            user.setFirstLogin(true);
            String formattedDate = LocalDateTime.now()
           .format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
            user.setUpdatedAt(formattedDate);
            user.setCreatedAt(formattedDate);
            adminDtoOut.setEmployeeMessage("Employee added successfully");
            userRepository.save(user);
            return adminDtoOut;
    }
    /**
     * to update employee.
     * @throws NotFoundException.
     */
    @Override
    public final AdminDtoOut updateEmployee(final
           UpdateDtoIn updateDtoIn)
                  throws NotFoundException {
        AdminDtoOut adminDtoOut = new AdminDtoOut();
    User user =
         userRepository.findById(updateDtoIn.getUserId()).orElseThrow(() ->
         new NotFoundException("Employee Not found"));
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
         String formattedDate = LocalDateTime.now()
         .format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
         user.setUpdatedAt(formattedDate);
         userRepository.save(user);
         adminDtoOut.setEmployeeMessage("Employee Updated successfully");
         return adminDtoOut;
        }
    /**
     * search employee.
     */
    @Override
    public final UserDto getSearchEmployee(final String employeeId) {
        Optional<User> user =
                userRepository.findByEmployeeId(employeeId);
        UserDto userDto = new UserDto();
        User userData = user.get();
        userDto.setEmployeeId(userData.getEmployeeId());
        userDto.setFirstName(userData.getFirstName());
        userDto.setLastName(userData.getLastName());
        userDto.setEmail(userData.getEmail());
        userDto.setDateOfBirth(userData.getDateOfBirth());
        userDto.setDateOfJoining(userData.getDateOfJoining());
        userDto.setPassword(userData.getPassword());
        userDto.setPhoneNumber(userData.getPhoneNumber());
        userDto.setDesignation(userData.getDesignation());
        userDto.setRole(userData.getRole());
        userDto.setDateOfExit(userData.getDateOfExit());
        userDto.setLocation(userData.getLocation());
        userDto.setUserId(userData.getUserId());
        return userDto;
    }
}
