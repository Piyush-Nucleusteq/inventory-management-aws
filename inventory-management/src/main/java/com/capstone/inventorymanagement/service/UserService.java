package com.capstone.inventorymanagement.service;

import java.util.List;
import com.capstone.inventorymanagement.domain.User;
import com.capstone.inventorymanagement.dto.AdminDtoOut;
import com.capstone.inventorymanagement.dto.LoginDtoIn;
import com.capstone.inventorymanagement.dto.LoginDtoOut;
import com.capstone.inventorymanagement.dto.UserDto;
import com.capstone.inventorymanagement.exception.NotFoundException;
import com.capstone.inventorymanagement.exception.RecordAlreadyExistException;
import com.capstone.inventorymanagement.exception.UnauthorizedException;

/**
 * @author piyush
 *
 */
public interface UserService {
      /**
     * @return all the users.
     */
    List<User> getAllUser();
     /**
     * @param userDto : user dto object
     * @return created user.
     * @throws RecordAlreadyExistException : record already exist.
     */
    String createUser(UserDto userDto) throws RecordAlreadyExistException;
    /**
     * @param loginDtoIn : requesuting parameters from loginDtoIn class.
     * @return name and role.
     * @throws UnauthorizedException : invalid credentials.
     */
    LoginDtoOut loginUser(LoginDtoIn loginDtoIn) throws UnauthorizedException;
    /**
     * @param loginDtoIn login dto in.
     * @return admin dto out.
     * @throws NotFoundException : not found exception.
     */
    AdminDtoOut resetPassword(LoginDtoIn loginDtoIn) throws NotFoundException;
}
