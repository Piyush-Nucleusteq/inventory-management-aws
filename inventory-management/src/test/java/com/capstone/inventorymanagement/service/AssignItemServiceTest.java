package com.capstone.inventorymanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capstone.inventorymanagement.controller.AssignItemController;
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

public class AssignItemServiceTest {
	@Mock
	AssignItemController assignItemController;
	@Mock
	AssignItemRepository assignItemRepository;

	@Mock
	ItemRepository itemRepository;

	@Mock
	UserRepository userRepository;

	@Mock
	AssignItemService assignItemService;

	@InjectMocks
	AssignItemServiceImpl assignItemServiceImpl;

	@Test
	public void getALlAssignItem() {
		MockitoAnnotations.openMocks(this);

		int id = 6;
		int itemtableId = 5;
		int employeeTableId = 4;
		String employeeId = "N0033";
		String itemReceivedAt = "Home";
		String assignedDate = "28/09/2000";
		String createdAt = "993388";
		String updatedAt = "22/430/33";

		AssignItem assign = buildItem(id, itemtableId,
				employeeTableId, employeeId, itemReceivedAt,
				assignedDate, createdAt, updatedAt);

		List<AssignItem> assignList = new ArrayList<AssignItem>();
		assignList.add(assign);

		when(assignItemRepository.findAll()).thenReturn(assignList);
		assertEquals(assignList,
				assignItemServiceImpl.getAllAssignItem());
	}

	@Test
	public void getAllUnAssignedItemTest() {
		MockitoAnnotations.openMocks(this);
		int itemId = 1;
		String itemName = "itemName";
		String itemNumber = "itemNumber";
		String itemType = "itemType";
		String dateOfPurchase = "dateOfPurchase";
		String itemWarrantyPeriod = "itemWarrantyPeriod";
		String itemLocation = "itemLocation";
		String itemCondition = "itemCondition";
		boolean isItemAssigned = false;
		String incidentsIfAny = "incidentsIfAny";

		Item item = buildItem(itemId, itemName, itemNumber, itemType,
				dateOfPurchase, itemWarrantyPeriod, itemLocation,
				itemCondition, isItemAssigned, incidentsIfAny);
		List<Item> itemList = new ArrayList<Item>();
		itemList.add(item);

		when(itemRepository.findAllByisItemAssigned(false))
				.thenReturn(itemList);
		assertEquals(itemList,
				assignItemServiceImpl.getUnAssignedItem());
	}

	@Test
	public void getAssignItemByEmployeeIdTest() {
		MockitoAnnotations.openMocks(this);
		List<AssignItemDtoOut> assignedItemInDtolist = new ArrayList<AssignItemDtoOut>();
		int id = 6;
		int itemtableId = 5;
		int employeeTableId = 4;
		String employeeId = "N0033";
		String itemReceivedAt = "Home";
		String assignedDate = "28/09/2000";
		String createdAt = "993388";
		String updatedAt = "22/430/33";
		AssignItem assign = buildItem(id, itemtableId,
				employeeTableId, employeeId, itemReceivedAt,
				assignedDate, createdAt, updatedAt);

		List<AssignItem> assignItemList = new ArrayList<AssignItem>();
		int itemId = 1;
		String itemName = "itemName";
		String itemNumber = "itemNumber";
		String itemType = "itemType";
		String dateOfPurchase = "dateOfPurchase";
		String itemWarrantyPeriod = "itemWarrantyPeriod";
		String itemLocation = "itemLocation";
		String itemCondition = "itemCondition";
		boolean isItemAssigned = false;
		String incidentsIfAny = "incidentsIfAny";
		Item item = buildItem(itemId, itemName, itemNumber, itemType,
				dateOfPurchase, itemWarrantyPeriod, itemLocation,
				itemCondition, isItemAssigned, incidentsIfAny);

		int userId = 6;
		String firstName = "firstname";
		String lastName = "lastName";
		String email = "email@email.com";
		String dateOfBirth = "daateOfBirth";
		String phoneNumber = "phoneNumber";
		String password = "password";
		String designation = "designation";
		String dateOfJoining = "dateOfJoining";
		String role = "role";
		String dateOfExit = "dateOfExit";
		String location = "location";

		User user1 = buildUser(userId, employeeId, firstName,
				lastName, email, dateOfBirth, phoneNumber, password,
				designation, dateOfJoining, role, dateOfExit,
				location, createdAt, updatedAt);

		assignItemList.add(assign);

		when(assignItemRepository.findByEmployeeId(employeeId))
				.thenReturn(assignItemList);
		when(userRepository.findById(employeeTableId))
				.thenReturn(Optional.of(user1));
		when(itemRepository.findById(itemtableId))
				.thenReturn(Optional.of(item));
		AssignItemDtoOut assignedItemOutDto = new AssignItemDtoOut();
		assignedItemOutDto.setId(assign.getId());
		assignedItemOutDto.setFirstName(user1.getFirstName());
		assignedItemOutDto.setLastName(user1.getLastName());
		assignedItemOutDto.setEmail(user1.getEmail());
		assignedItemOutDto.setEmployeeId(assign.getEmployeeId());
		assignedItemOutDto.setItemName(item.getItemName());
		assignedItemOutDto.setItemNumber(item.getItemNumber());
		assignedItemOutDto.setItemCondition(item.getItemCondition());
		assignedItemOutDto
				.setIncidentsIfAny(item.getIncidentsIfAny());
		assignedItemOutDto.setItemTableId(assign.getItemtableId());
		assignedItemOutDto
				.setEmployeeTableId(assign.getEmployeeTableId());
		assignedItemOutDto
				.setDateOfAssigned(assign.getAssignedDate());
		assignedItemInDtolist.add(assignedItemOutDto);
		assertEquals(assignedItemInDtolist,
				assignItemServiceImpl.getAssignItem(employeeId));
	}

	@Test
	public void assignItemPost() throws RecordAlreadyExistException {
		MockitoAnnotations.openMocks(this);
		List<AssignItemDtoIn> assignItemDtoInList = new ArrayList<AssignItemDtoIn>();
		int id = 6;
		int itemtableId = 5;
		int employeeTableId = 4;
		String employeeId = "N0033";
		String itemReceivedAt = "Home";
		String assignedDate = "28/09/2000";
		String createdAt = "993388";
		String updatedAt = "22/430/33";
		AssignItem assign = buildItem(id, itemtableId,
				employeeTableId, employeeId, itemReceivedAt,
				assignedDate, createdAt, updatedAt);

		int itemId = 1;
		String itemName = "itemName";
		String itemNumber = "itemNumber";
		String itemType = "itemType";
		String dateOfPurchase = "dateOfPurchase";
		String itemWarrantyPeriod = "itemWarrantyPeriod";
		String itemLocation = "itemLocation";
		String itemCondition = "itemCondition";
		boolean isItemAssigned = false;
		String incidentsIfAny = "incidentsIfAny";
		Item item = buildItem(itemId, itemName, itemNumber, itemType,
				dateOfPurchase, itemWarrantyPeriod, itemLocation,
				itemCondition, isItemAssigned, incidentsIfAny);

		when(itemRepository.findById(itemtableId))
				.thenReturn(Optional.of(item));
		AssignItemDtoIn assignedItem = new AssignItemDtoIn();
		assignedItem.setAssignedDate(assign.getAssignedDate());
		assignedItem.setEmployeeId(assign.getEmployeeId());
		assignedItem.setEmployeeTableId(assign.getEmployeeTableId());
		assignedItem.setItemReceivedAt(assign.getItemReceivedAt());
		assignedItem.setItemtableId(assign.getItemtableId());
		assignedItem.setId(assign.getId());
		assignItemDtoInList.add(assignedItem);

		AdminDtoOut adminDtoOut = new AdminDtoOut();
		adminDtoOut.setEmployeeMessage("Item Assigned Successfuly");

		assertEquals(adminDtoOut, assignItemServiceImpl
				.assignItem(assignItemDtoInList));
	}

	@Test
	public void deleteItemTest() throws NotFoundException {

		MockitoAnnotations.openMocks(this);
		AdminDtoOut adminDtoOut = new AdminDtoOut();
		adminDtoOut.setEmployeeMessage("Item Deleted Successfuly");
		int id = 6;
		int itemtableId = 5;
		int employeeTableId = 4;
		String employeeId = "N0033";
		String itemReceivedAt = "Home";
		String assignedDate = "28/09/2000";
		String createdAt = "993388";
		String updatedAt = "22/430/33";
		AssignItem assign = buildItem(id, itemtableId,
				employeeTableId, employeeId, itemReceivedAt,
				assignedDate, createdAt, updatedAt);

		int itemId = 1;
		String itemName = "itemName";
		String itemNumber = "itemNumber";
		String itemType = "itemType";
		String dateOfPurchase = "dateOfPurchase";
		String itemWarrantyPeriod = "itemWarrantyPeriod";
		String itemLocation = "itemLocation";
		String itemCondition = "itemCondition";
		boolean isItemAssigned = false;
		String incidentsIfAny = "incidentsIfAny";
		Item item = buildItem(itemId, itemName, itemNumber, itemType,
				dateOfPurchase, itemWarrantyPeriod, itemLocation,
				itemCondition, isItemAssigned, incidentsIfAny);

		when(assignItemRepository.findById(itemId))
				.thenReturn(Optional.of(assign));
		when(itemRepository.findById(itemtableId))
				.thenReturn(Optional.of(item));
		assertEquals(adminDtoOut,
				assignItemServiceImpl.deleteItem(itemId));
	}

	@Test
	public void allAssignedItemTest() {

		MockitoAnnotations.openMocks(this);
		List<AssignItemDtoOut> assignedItemInDtolist = new ArrayList<AssignItemDtoOut>();

		int id = 6;
		int itemtableId = 5;
		int employeeTableId = 4;
		String employeeId = "N0033";
		String itemReceivedAt = "Home";
		String assignedDate = "28/09/2000";
		String createdAt = "993388";
		String updatedAt = "22/430/33";
		AssignItem assign = buildItem(id, itemtableId,
				employeeTableId, employeeId, itemReceivedAt,
				assignedDate, createdAt, updatedAt);

		int itemId = 1;
		String itemName = "itemName";
		String itemNumber = "itemNumber";
		String itemType = "itemType";
		String dateOfPurchase = "dateOfPurchase";
		String itemWarrantyPeriod = "itemWarrantyPeriod";
		String itemLocation = "itemLocation";
		String itemCondition = "itemCondition";
		boolean isItemAssigned = false;
		String incidentsIfAny = "incidentsIfAny";
		Item item = buildItem(itemId, itemName, itemNumber, itemType,
				dateOfPurchase, itemWarrantyPeriod, itemLocation,
				itemCondition, isItemAssigned, incidentsIfAny);

		int userId = 6;
		String firstName = "firstname";
		String lastName = "lastName";
		String email = "email@email.com";
		String dateOfBirth = "daateOfBirth";
		String phoneNumber = "phoneNumber";
		String password = "password";
		String designation = "designation";
		String dateOfJoining = "dateOfJoining";
		String role = "role";
		String dateOfExit = "dateOfExit";
		String location = "location";

		User user = buildUser(userId, employeeId, firstName, lastName,
				email, dateOfBirth, phoneNumber, password,
				designation, dateOfJoining, role, dateOfExit,
				location, createdAt, updatedAt);
		List<AssignItem> assignItemList = new ArrayList<AssignItem>();

		assignItemList.add(assign);

		when(assignItemRepository.findAll())
				.thenReturn(assignItemList);
		when(userRepository.findById(employeeTableId))
				.thenReturn(Optional.of(user));
		when(itemRepository.findById(itemtableId))
				.thenReturn(Optional.of(item));
		AssignItemDtoOut assignedItemOutDto = new AssignItemDtoOut();
		assignedItemOutDto.setId(assign.getId());
		assignedItemOutDto.setFirstName(user.getFirstName());
		assignedItemOutDto.setLastName(user.getLastName());
		assignedItemOutDto.setEmail(user.getEmail());
		assignedItemOutDto.setEmployeeId(assign.getEmployeeId());
		assignedItemOutDto.setItemName(item.getItemName());
		assignedItemOutDto.setItemNumber(item.getItemNumber());
		assignedItemOutDto.setItemCondition(item.getItemCondition());
		assignedItemOutDto
				.setIncidentsIfAny(item.getIncidentsIfAny());
		assignedItemOutDto.setItemTableId(assign.getItemtableId());
		assignedItemOutDto
				.setEmployeeTableId(assign.getEmployeeTableId());
		assignedItemOutDto
				.setDateOfAssigned(assign.getAssignedDate());
		assignedItemInDtolist.add(assignedItemOutDto);
		assertEquals(assignedItemInDtolist,
				assignItemServiceImpl.allAssignedItem());
	}

	public Item buildItem(int itemId, String itemName,
			String itemNumber, String itemType, String dateOfPurchase,
			String itemWarrantyPeriod, String itemLocation,
			String itemCondition, boolean isItemAssigned,
			String incidentsIfAny) {
		Item item = new Item();
		item.setItemId(itemId);
		item.setItemName(itemName);
		item.setItemNumber(itemNumber);
		item.setItemType(itemType);
		item.setDateOfPurchase(dateOfPurchase);
		item.setItemWarrantyPeriod(itemWarrantyPeriod);
		item.setItemLocation(itemLocation);
		item.setItemCondition(itemCondition);
		item.setIsItemAssigned(isItemAssigned);
		item.setIncidentsIfAny(incidentsIfAny);
		return item;

	}

	public AssignItem buildItem(int id, int itemtableId,
			int employeeTableId, String employeeId,
			String itemReceivedAt, String assignedDate,
			String createdAt, String updatedAt) {
		AssignItem assign = new AssignItem();

		assign.setId(id);
		assign.setItemtableId(itemtableId);
		assign.setEmployeeTableId(employeeTableId);
		assign.setEmployeeId(employeeId);
		assign.setItemReceivedAt(itemReceivedAt);
		assign.setAssignedDate(assignedDate);
		assign.setCreatedAt(createdAt);
		assign.setUpdatedAt(updatedAt);
		return assign;

	}

	public User buildUser(int userId, String employeeId,
			String firstName, String lastName, String email,
			String dateOfBirth, String phoneNumber, String password,
			String designation, String dateOfJoining, String role,
			String dateOfExit, String location, String createdAt,
			String updatedAt) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setDateOfBirth(dateOfBirth);
		user.setDateOfJoining(dateOfJoining);
		user.setEmployeeId(employeeId);
		user.setPassword(password);
		user.setPhoneNumber(phoneNumber);
		user.setDesignation(designation);
		user.setUserId(userId);
		user.setRole(role);
		user.setDateOfExit(dateOfExit);
		user.setLocation(location);
		user.setCreatedAt(createdAt);
		user.setUpdatedAt(updatedAt);
		return user;
	}

}
