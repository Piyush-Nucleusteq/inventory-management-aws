package com.capstone.inventorymanagement.service;
import java.util.List;

import javax.validation.Valid;

import com.capstone.inventorymanagement.domain.User;
import com.capstone.inventorymanagement.dto.AdminDtoOut;
import com.capstone.inventorymanagement.dto.UpdateDtoIn;
import com.capstone.inventorymanagement.dto.UserDto;
import com.capstone.inventorymanagement.exception.NotFoundException;
import com.capstone.inventorymanagement.exception.RecordAlreadyExistException;
/**
 * @author Admin service.
 *
 */
public interface AdminService {
    /**
     * @return all employee.
     */
    List<User> getAllEmployee();
    /**
     * @param userDto : userDto object.
     * @return added employee.
     * @throws RecordAlreadyExistException : record already exist.
     */
    AdminDtoOut addEmployee(@Valid UserDto userDto)
         throws RecordAlreadyExistException;
    /**
     * @param updateDtoIn : userDto Out object.
     * @return updated employee.
     * @throws NotFoundException : record not found.
     */
    AdminDtoOut updateEmployee(@Valid UpdateDtoIn updateDtoIn)
         throws NotFoundException;
    /**
     * @param employeeId : employee id.
     * @return search employee.
     */
    UserDto getSearchEmployee(String employeeId);
}
