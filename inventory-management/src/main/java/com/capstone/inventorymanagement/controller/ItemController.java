package com.capstone.inventorymanagement.controller;
import java.util.List;
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
import com.capstone.inventorymanagement.domain.Item;
import com.capstone.inventorymanagement.dto.ItemDtoIn;
import com.capstone.inventorymanagement.dto.ItemDtoOut;
import com.capstone.inventorymanagement.dto.UpdateItemDtoIn;
import com.capstone.inventorymanagement.exception.NotFoundException;
import com.capstone.inventorymanagement.exception.RecordAlreadyExistException;
import com.capstone.inventorymanagement.service.ItemService;
/**
 * @author item controller class.
 *
 */
@CrossOrigin("*")
@RestController
public class ItemController {
    /**
     * item service refrence.
     */
    @Autowired
    private ItemService itemService;
    /**
     * @return list of items.
     */
    @GetMapping("/item")
    public final List<Item> getAllItem() {
        return itemService.getAllItem();
   }
    /**
     * @param itemDto : item dto object.
     * @return message as response entity which is stored in ItemDtoOut.
     * @throws RecordAlreadyExistException : record already exist.
     */
    @PostMapping("/item")
    public final ResponseEntity<ItemDtoOut> addItem(
             final @Valid @RequestBody ItemDtoIn itemDto)
              throws RecordAlreadyExistException {
         ItemDtoOut itemDtoOut  = itemService.addItem(itemDto);
         return ResponseEntity.status(HttpStatus.OK).body(itemDtoOut);
      }
    /**
     * @param updateItemDtoIn : item update dto in object.
     * @return item dto out object as a message.
     * @throws NotFoundException : record not found.
     */
    @PutMapping("/item")
    public final ResponseEntity<ItemDtoOut> updateItem(@Valid @RequestBody
       final UpdateItemDtoIn updateItemDtoIn) throws NotFoundException {
        ItemDtoOut updatedResult = itemService.updateItem(updateItemDtoIn);
      return ResponseEntity.status(HttpStatus.OK).body(updatedResult);
    }
}
