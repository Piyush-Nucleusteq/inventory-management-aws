package com.capstone.inventorymanagement.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.capstone.inventorymanagement.dto.AdminDtoOut;
import com.capstone.inventorymanagement.dto.UpdateDtoIn;
import com.capstone.inventorymanagement.dto.UserDto;
import com.capstone.inventorymanagement.exception.NotFoundException;
import com.capstone.inventorymanagement.exception.RecordAlreadyExistException;
import com.capstone.inventorymanagement.domain.User;
import com.capstone.inventorymanagement.service.AdminService;
/**
 * @author admin controller class.
 *
 */
@CrossOrigin("*")
@RestController
public class AdminController {
    /**
     * admin service refrence objecr.
     */
    @Autowired
    private AdminService adminService;
    /**
     * @return list of employee.
     */
    @GetMapping("/employee")
    public final List<User> getAllEmployee() {
        return adminService.getAllEmployee();
   }
    /**
     * @param userDto : user dto object.
     * @return response as message.
     * @throws RecordAlreadyExistException : record already exist.
     */
    @PostMapping("/employee")
    public final ResponseEntity<AdminDtoOut> addEmployee(
       final @Valid @RequestBody
           UserDto userDto) throws RecordAlreadyExistException {
        AdminDtoOut adminDtoOut  = adminService.addEmployee(userDto);
            return ResponseEntity.status(HttpStatus.OK).body(adminDtoOut);
      }
    /**
     * @param updateDtoIn : employee update dto in object.
     * @return admin dto out object as a message.
     * @throws NotFoundException : record not found.
     */
    @PutMapping("/employee")
    public final ResponseEntity<AdminDtoOut> updateEmployee(@Valid @RequestBody
       final UpdateDtoIn updateDtoIn) throws NotFoundException {
        AdminDtoOut updatedResult = adminService.updateEmployee(updateDtoIn);
      return ResponseEntity.status(HttpStatus.OK).body(updatedResult);
 }
    /**
     * @param employeeId : employee id.
     * @return searched employee.
     */
    @GetMapping("/searchEmployee/{employeeId}")
    public final UserDto getSearchEmployee(@PathVariable
         final String employeeId) {
         return adminService.getSearchEmployee(employeeId);
    }
}
