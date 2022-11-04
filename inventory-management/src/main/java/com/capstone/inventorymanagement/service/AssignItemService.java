package com.capstone.inventorymanagement.service;

import java.util.List;

import com.capstone.inventorymanagement.domain.AssignItem;
import com.capstone.inventorymanagement.domain.Item;
import com.capstone.inventorymanagement.dto.AdminDtoOut;
import com.capstone.inventorymanagement.dto.AssignItemDtoIn;
import com.capstone.inventorymanagement.dto.AssignItemDtoOut;
import com.capstone.inventorymanagement.exception.NotFoundException;
import com.capstone.inventorymanagement.exception.RecordAlreadyExistException;
    /**
     * @author Assign item service.
     *
     */
    public interface AssignItemService {
    /**
     * @return item.
     */
    List<AssignItem> getAllAssignItem();
    /**
     * @param employeeId : employee id as an input.
     * @return get item according to employee id.
     */
    List<AssignItemDtoOut> getAssignItem(String employeeId);
    /**
     * @return un assigned item.
     */
    List<Item> getUnAssignedItem();
    /**
     * @param assignItemDtoIn : assign item dto in.
     * @return assign item.
     * @throws RecordAlreadyExistException : record already exist.
     */
    AdminDtoOut assignItem(List<AssignItemDtoIn> assignItemDtoIn)
            throws RecordAlreadyExistException;
    /**
     * @param itemId : item id.
     * @return delete message.
     * @throws NotFoundException : not found.
     */
    AdminDtoOut deleteItem(int itemId) throws NotFoundException;
    /**
     * @return all assigned items.
     */
    List<AssignItemDtoOut> allAssignedItem();
}
