package com.capstone.inventorymanagement.controller;
/**
* @author piyush
*
*/

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import com.capstone.inventorymanagement.domain.User;
import com.capstone.inventorymanagement.dto.AdminDtoOut;
import com.capstone.inventorymanagement.dto.LoginDtoIn;
import com.capstone.inventorymanagement.dto.LoginDtoOut;
import com.capstone.inventorymanagement.dto.UserDto;
import com.capstone.inventorymanagement.exception.NotFoundException;
import com.capstone.inventorymanagement.exception.RecordAlreadyExistException;
import com.capstone.inventorymanagement.exception.UnauthorizedException;
import com.capstone.inventorymanagement.service.UserService;
import lombok.extern.slf4j.Slf4j;
/**
* @author piyush
*
*/
@Slf4j
@CrossOrigin("*")
@RestController
public class UserController {
     /**
     * reference object of repository interface.
     */
    @Autowired
     private UserService userService;
     /**
     * @return all the users.
     */
    @GetMapping("/user")
    public final List<User> getAllUser() {
         return userService.getAllUser();
    }
    /**
     * @param userDto : userDto object.
     * @return created user.
     * @throws RecordAlreadyExistException : record already exist.
     */
    @PostMapping("/user")
    public final ResponseEntity<String> createUser(final @Valid @RequestBody
         UserDto userDto) throws RecordAlreadyExistException {
         String result = userService.createUser(userDto);
         return ResponseEntity.status(HttpStatus.OK).body(result);
       }
    /**
     * @param loginDtoIn the entry we are going to provide.
     * @return logindto object.
     * @throws UnauthorizedException : invalid credentials.
     */
    @PostMapping("/loginUser")
    public final ResponseEntity<LoginDtoOut>
    loginUser(@Valid @RequestBody final LoginDtoIn loginDtoIn)
            throws UnauthorizedException {
        log.info("Login Api to verify the credentials"
                   + " of the login person");
            LoginDtoOut loginDtoOut =
                    userService.loginUser(loginDtoIn);
              if (loginDtoOut.getFirstName() == null) {
                  return ResponseEntity.status(
                       HttpStatus.BAD_REQUEST).body(null);
                 } else {
                   return ResponseEntity.of(Optional.of(loginDtoOut));
                }
        }
    /**
     * @param loginDtoIn : login dto in.
     * @return adminDtoOut.
     * @throws NotFoundException : not found exception.
     */
    @PutMapping("/reset")
    public final ResponseEntity<AdminDtoOut> resetPassword(@RequestBody
           final LoginDtoIn loginDtoIn) throws NotFoundException {
        AdminDtoOut updatedResult = userService.resetPassword(loginDtoIn);
        return ResponseEntity.status(HttpStatus.OK).body(updatedResult);
    }
}
