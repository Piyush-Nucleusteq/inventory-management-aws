package com.capstone.inventorymanagement.service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capstone.inventorymanagement.domain.AssignItem;
import com.capstone.inventorymanagement.domain.Item;
import com.capstone.inventorymanagement.domain.User;
import com.capstone.inventorymanagement.dto.AdminDtoOut;
import com.capstone.inventorymanagement.dto.AssignItemDtoIn;
import com.capstone.inventorymanagement.dto.AssignItemDtoOut;
import com.capstone.inventorymanagement.exception.NotFoundException;
import com.capstone.inventorymanagement.exception.RecordAlreadyExistException;
import com.capstone.inventorymanagement.repository.AssignItemRepository;
import com.capstone.inventorymanagement.repository.ItemRepository;
import com.capstone.inventorymanagement.repository.UserRepository;
/**
 * @author Assign Item Service Impl.
 *
 */
@Service
public class AssignItemServiceImpl implements AssignItemService {
    /**
     * refrence object for assign item repository.
     */
    @Autowired
    private AssignItemRepository assignItemRepository;
    /**
     * refrence object for item repository.
     */
    @Autowired
    private ItemRepository itemRepository;
    /**
     * refrence object for user repository.
     */
    @Autowired
    private UserRepository userRepository;
    /**
     * get all api.
     */
    @Override
    public final List<AssignItem> getAllAssignItem() {
       return assignItemRepository.findAll();
    }
    /**
     * get item according to employee id api.
     */
    @Override
    public final List<AssignItemDtoOut> getAssignItem(final String employeeId) {
        List<AssignItem> assignItem =
                 assignItemRepository.findByEmployeeId(employeeId);
        List<AssignItemDtoOut> dtoOut = new ArrayList<AssignItemDtoOut>();
        for (AssignItem assignedItem : assignItem) {
            Optional<User> user =
                      userRepository.findById(
                              assignedItem.getEmployeeTableId());
            User userData = user.get();
            Optional<Item> item =
                       itemRepository.findById(assignedItem.getItemtableId());
            Item itemdata = item.get();
            AssignItemDtoOut assignItemDtoOut =
                    new AssignItemDtoOut();
            assignItemDtoOut.setEmail(userData.getEmail());
            assignItemDtoOut.setEmployeeId(userData.getEmployeeId());
            assignItemDtoOut.setFirstName(userData.getFirstName());
            assignItemDtoOut.setLastName(userData.getLastName());
            assignItemDtoOut.setIncidentsIfAny(itemdata.getIncidentsIfAny());
            assignItemDtoOut.setItemName(itemdata.getItemName());
            assignItemDtoOut.setItemNumber(itemdata.getItemNumber());
            assignItemDtoOut.setItemCondition(itemdata.getItemCondition());
            assignItemDtoOut.setItemTableId(assignedItem.getItemtableId());
            assignItemDtoOut.setEmployeeTableId(
            assignedItem.getEmployeeTableId());
            assignItemDtoOut.setId(assignedItem.getId());
            assignItemDtoOut.setDateOfAssigned(assignedItem.getAssignedDate());
            dtoOut.add(assignItemDtoOut);
        }
        return dtoOut;
    }
    /**
     * get un assigned items.
     */
    @Override
    public final List<Item> getUnAssignedItem() {
        return itemRepository.findAllByisItemAssigned(false);
    }
    /**
     * assign Item Api.
     */
    @Override
    public final AdminDtoOut assignItem(final
            List<AssignItemDtoIn> assignItemDtoIn)
                 throws RecordAlreadyExistException {
        List<AssignItem> dto = new ArrayList<AssignItem>();
        AdminDtoOut adminDtoOut = new AdminDtoOut();
        for (AssignItemDtoIn assignedItem : assignItemDtoIn) {
        if (assignItemRepository.findByItemtableId(
             assignedItem.getItemtableId()).isPresent()) {
              throw new RecordAlreadyExistException("Item already exist");
         }
         AssignItem assign = new AssignItem();
         assign.setAssignedDate(assignedItem.getAssignedDate());
         assign.setEmployeeId(assignedItem.getEmployeeId());
         assign.setEmployeeTableId(assignedItem.getEmployeeTableId());
         assign.setItemReceivedAt(assignedItem.getItemReceivedAt());
         assign.setItemtableId(assignedItem.getItemtableId());
         String formattedDate = LocalDateTime.now()
                 .format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
                  assign.setUpdatedAt(formattedDate);
                  assign.setCreatedAt(formattedDate);
         Optional<Item> item =
                 itemRepository.findById(assignedItem.getItemtableId());
         Item itemdata = item.get();
         itemdata.setIsItemAssigned(true);
         itemRepository.save(itemdata);
         dto.add(assign);
     }
     adminDtoOut.setEmployeeMessage("Item Assigned Successfuly");
     assignItemRepository.saveAll(dto);
    return adminDtoOut;
    }
    /**
     * delete item api.
     */
    @Override
    public final AdminDtoOut deleteItem(final int itemId)
              throws NotFoundException {
        Optional<AssignItem> assignItem =
                assignItemRepository.findById(itemId);
        if (assignItem.isPresent()) {
            int tableId = assignItem.get().getItemtableId();
            Optional<Item> item =
                 itemRepository.findById(tableId);
      item.get().setIsItemAssigned(false);
      itemRepository.save(item.get());
      assignItemRepository.deleteById(assignItem.get().getId());
      AdminDtoOut adminDtoOut = new AdminDtoOut();
      adminDtoOut.setEmployeeMessage("Item Deleted Successfuly");
      return adminDtoOut;
        } else {
            throw new NotFoundException("Records Not Found");
        }
    }
    /**
     * all assigned item api.
     */
    @Override
    public final List<AssignItemDtoOut> allAssignedItem() {
        List<AssignItem> assignItem =
                 assignItemRepository.findAll();
        List<AssignItemDtoOut> dtoOut = new ArrayList<AssignItemDtoOut>();
        for (AssignItem assignedItem : assignItem) {
            Optional<User> user =
                      userRepository.findById(
                                  assignedItem.getEmployeeTableId());
            User userData = user.get();
            Optional<Item> item =
                       itemRepository.findById(assignedItem.getItemtableId());
            Item itemdata = item.get();
            AssignItemDtoOut assignItemDtoOut =
                    new AssignItemDtoOut();
            assignItemDtoOut.setEmail(userData.getEmail());
            assignItemDtoOut.setEmployeeId(userData.getEmployeeId());
            assignItemDtoOut.setFirstName(userData.getFirstName());
            assignItemDtoOut.setLastName(userData.getLastName());
            assignItemDtoOut.setIncidentsIfAny(itemdata.getIncidentsIfAny());
            assignItemDtoOut.setItemName(itemdata.getItemName());
            assignItemDtoOut.setItemNumber(itemdata.getItemNumber());
            assignItemDtoOut.setItemCondition(itemdata.getItemCondition());
            assignItemDtoOut.setItemTableId(assignedItem.getItemtableId());
            assignItemDtoOut.setEmployeeTableId(
                   assignedItem.getEmployeeTableId());
            assignItemDtoOut.setId(assignedItem.getId());
            assignItemDtoOut.setDateOfAssigned(assignedItem.getAssignedDate());
            dtoOut.add(assignItemDtoOut);
        }
        return dtoOut;
    }
}
