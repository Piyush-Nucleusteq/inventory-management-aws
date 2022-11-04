package com.capstone.inventorymanagement.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capstone.inventorymanagement.domain.User;
import com.capstone.inventorymanagement.dto.AdminDtoOut;
import com.capstone.inventorymanagement.dto.LoginDtoIn;
import com.capstone.inventorymanagement.dto.LoginDtoOut;
import com.capstone.inventorymanagement.dto.UserDto;
import com.capstone.inventorymanagement.exception.NotFoundException;
import com.capstone.inventorymanagement.exception.RecordAlreadyExistException;
import com.capstone.inventorymanagement.exception.UnauthorizedException;
import com.capstone.inventorymanagement.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
/**
 * @author piyush
 *
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    /**
     * reference object of user repository.
     */
    @Autowired
    private UserRepository userRepository;
    /**
     * method to get all the users.
     */
    @Override
    public final List<User> getAllUser() {
        return userRepository.findAll();
    }
    /**
     * method to create user.
     * @throws RecordAlreadyExistException.
     */
    @Override
    public final String createUser(final UserDto userDto)
              throws RecordAlreadyExistException {
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new RecordAlreadyExistException("Record Already Exist");
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
        String formattedDate = LocalDateTime.now()
        .format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        user.setUpdatedAt(formattedDate);
        user.setCreatedAt(formattedDate);
        userRepository.save(user);
        return "Signed Up successfully";
    }
    /**
     * method for user to login.
     * @throws UnauthorizedException.
     */
    @Override
    public final LoginDtoOut loginUser(final LoginDtoIn loginDtoIn)
            throws UnauthorizedException {
        log.info("Getting employee info Method has been used");
        String em =  loginDtoIn.getEmail();
        String pass = loginDtoIn.getPassword();
        List<User> listUser =  userRepository.findAll();
        LoginDtoOut loginDtoOut = new LoginDtoOut();
        for (User user :  listUser) {
               if (em.equals(user.getEmail())
                   && pass.equals(user.getPassword())) {
                   loginDtoOut.setFirstName(user.getFirstName());
                   loginDtoOut.setRole(user.getRole());
                   loginDtoOut.setEmployeeId(user.getEmployeeId());
                   loginDtoOut.setFirstLogin(user.isFirstLogin());
                   log.info("role and first name");
                  return  loginDtoOut;
                 }
          }
        throw new UnauthorizedException("Invalid Credentials!");
    }
    /**
     * reset password api.
     */
    @Override
    public final AdminDtoOut resetPassword(final LoginDtoIn loginDtoIn)
             throws NotFoundException {
        log.info("reset password method has been hit");
        AdminDtoOut adminDtoOut = new AdminDtoOut();
        User user = userRepository.findByEmail(loginDtoIn.getEmail()).get();
        if (user == null) {
            throw new NotFoundException("User doesn't exist");
        }
        user.setPassword(loginDtoIn.getPassword());
        user.setFirstLogin(false);
        userRepository.save(user);
        adminDtoOut.setEmployeeMessage("Password reset successfully");
        return adminDtoOut;
    }
}
