package com.capstone.inventorymanagement.service;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capstone.inventorymanagement.domain.Item;
import com.capstone.inventorymanagement.dto.ItemDtoIn;
import com.capstone.inventorymanagement.dto.ItemDtoOut;
import com.capstone.inventorymanagement.dto.UpdateItemDtoIn;
import com.capstone.inventorymanagement.exception.NotFoundException;
import com.capstone.inventorymanagement.exception.RecordAlreadyExistException;
import com.capstone.inventorymanagement.repository.ItemRepository;
/**
 * @author Item Service Implemented class.
 *
 */
@Service
public class ItemServiceImpl implements ItemService {
    /**
     * reference object of item repository.
     */
    @Autowired
    private ItemRepository itemRepository;
    /**
     * list of item.
     */
    @Override
    public final List<Item> getAllItem() {
        return itemRepository.findAll();
    }
    /**
     * add item method calling.
     * @throws RecordAlreadyExistException .
     */
    @Override
    public final ItemDtoOut addItem(final
             @Valid ItemDtoIn itemDto)
                   throws RecordAlreadyExistException {
          ItemDtoOut itemDtoOut = new ItemDtoOut();
          if (itemRepository.findByItemNumber(
                    itemDto.getItemNumber()).isPresent()) {
               throw new RecordAlreadyExistException("Item Already Exist");
          }
        Item item = new Item();
        item.setItemId(itemDto.getItemId());
        item.setItemName(itemDto.getItemName());
        item.setItemNumber(itemDto.getItemNumber());
        item.setItemType(itemDto.getItemType());
        item.setDateOfPurchase(itemDto.getDateOfPurchase());
        item.setItemWarrantyPeriod(itemDto.getItemWarrantyPeriod());
        item.setItemLocation(itemDto.getItemLocation());
        item.setItemCondition(itemDto.getItemCondition());
        item.setIsItemAssigned(itemDto.isItemAssigned());
        item.setIncidentsIfAny(itemDto.getIncidentsIfAny());
        itemDtoOut.setMessage("Item added successfully");
        itemRepository.save(item);
        return itemDtoOut;
     }
    /**
     * to update item.
     * @throws NotFoundException.
     */
    @Override
    public final ItemDtoOut updateItem(final
            @Valid UpdateItemDtoIn updateItemDtoIn)
                 throws NotFoundException {
        ItemDtoOut itemDtoOut = new ItemDtoOut();
        Item item =
        itemRepository.findById(updateItemDtoIn.getItemId()).orElseThrow(() ->
        new NotFoundException("Item Not found"));
            item.setItemId(updateItemDtoIn.getItemId());
            item.setItemName(updateItemDtoIn.getItemName());
            item.setItemType(updateItemDtoIn.getItemType());
            item.setDateOfPurchase(updateItemDtoIn.getDateOfPurchase());
            item.setItemWarrantyPeriod(updateItemDtoIn.getItemWarrantyPeriod());
            item.setItemLocation(updateItemDtoIn.getItemLocation());
            item.setItemCondition(updateItemDtoIn.getItemCondition());
            item.setIsItemAssigned(updateItemDtoIn.isItemAssigned());
            item.setIncidentsIfAny(updateItemDtoIn.getIncidentsIfAny());
            itemDtoOut.setMessage("Item Updated successfully");
            itemRepository.save(item);
            return itemDtoOut;
     }
}
