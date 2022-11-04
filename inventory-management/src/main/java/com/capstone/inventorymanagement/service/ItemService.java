package com.capstone.inventorymanagement.service;
import java.util.List;


import com.capstone.inventorymanagement.domain.Item;
import com.capstone.inventorymanagement.dto.ItemDtoIn;
import com.capstone.inventorymanagement.dto.ItemDtoOut;
import com.capstone.inventorymanagement.dto.UpdateItemDtoIn;
import com.capstone.inventorymanagement.exception.NotFoundException;
import com.capstone.inventorymanagement.exception.RecordAlreadyExistException;
/**
 * @author piyush
 *
 */
public interface ItemService  {
    /**
     * @param itemDto : object which we will give. for calling api.
     * @return item dto in object.
     * @throws RecordAlreadyExistException : record already exist.
     */
    ItemDtoOut addItem(ItemDtoIn itemDto)
              throws RecordAlreadyExistException;
    /**
     * @return list of items.
     */
    List<Item> getAllItem();
    /**
     * @param updateItemDtoIn : item dto in as a request body.
     * @return item dto out object which sends message.
     * @throws NotFoundException : record not found.
     */
    ItemDtoOut updateItem(UpdateItemDtoIn updateItemDtoIn)
              throws NotFoundException;
//    /**
//     * @return un assigned item.
//     */
//    List<Item> getUnAssignedItem();
}
