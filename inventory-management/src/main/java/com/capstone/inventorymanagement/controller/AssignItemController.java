package com.capstone.inventorymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.inventorymanagement.domain.AssignItem;
import com.capstone.inventorymanagement.domain.Item;
import com.capstone.inventorymanagement.dto.AdminDtoOut;
import com.capstone.inventorymanagement.dto.AssignItemDtoIn;
import com.capstone.inventorymanagement.dto.AssignItemDtoOut;
import com.capstone.inventorymanagement.exception.NotFoundException;
import com.capstone.inventorymanagement.exception.RecordAlreadyExistException;
import com.capstone.inventorymanagement.service.AssignItemService;

/**
 * @author AssignItemController
 *
 */
@CrossOrigin("*")
@RestController
public class AssignItemController {
    /**
     * refrence object of assign item service.
     */
    @Autowired
    private AssignItemService assignItemService;
    /**
     * @return assign items.
     */
    @GetMapping("/AssignItem")
    public final List<AssignItem> getAllAssignItem() {
         return assignItemService.getAllAssignItem();
    }
    /**
     * @param employeeId : employee id.
     * @return assigned items for the employee.
     */
    @GetMapping("/AssignItem/{employeeId}")
    public final List<AssignItemDtoOut> getAssignItem(
             @PathVariable final String employeeId) {
        return assignItemService.getAssignItem(employeeId);
    }
    /**
     * @return un-assigned items.
     */
    @GetMapping("/UnAssignedItem")
    public final List<Item> getUnAssignedItem() {
        return assignItemService.getUnAssignedItem();
    }
    /**
     * @param assignItemDtoIn : assign item dto in.
     * @return list of assigned items.
     * @throws RecordAlreadyExistException : record already exist.
     */
    @PostMapping("/AssignItem")
    public final ResponseEntity<AdminDtoOut> assignItem(@RequestBody
           final  List<AssignItemDtoIn> assignItemDtoIn)
                  throws RecordAlreadyExistException {
        System.out.println("----->" + assignItemDtoIn);
    AdminDtoOut adminDtoOut =
              assignItemService.assignItem(assignItemDtoIn);
         return ResponseEntity.status(HttpStatus.OK).body(adminDtoOut);
    }
    /**
     * @param itemId : item id.
     * @return delete message.
     * @throws NotFoundException : not found.
     */
    @DeleteMapping("/AssignItem/delete/{itemId}")
    public final ResponseEntity<AdminDtoOut> deleteItem(@PathVariable
          final int itemId) throws NotFoundException {
          AdminDtoOut adminDtoOut = assignItemService.deleteItem(itemId);
          return ResponseEntity.status(HttpStatus.OK).body(adminDtoOut);
    }
    /**
     * @return all assigned items.
     */
    @GetMapping("/AllAssignedItem")
    public final List<AssignItemDtoOut> allAssignedItem() {
        return assignItemService.allAssignedItem();
    }
}
