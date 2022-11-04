package com.capstone.inventorymanagement.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capstone.inventorymanagement.domain.AssignItem;
import com.capstone.inventorymanagement.domain.Item;
import com.capstone.inventorymanagement.dto.AdminDtoOut;
import com.capstone.inventorymanagement.dto.AssignItemDtoIn;
import com.capstone.inventorymanagement.dto.AssignItemDtoOut;
import com.capstone.inventorymanagement.repository.AssignItemRepository;
import com.capstone.inventorymanagement.service.AssignItemService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class AssignItemControllerTest {

	@InjectMocks
	private AssignItemController assignItemController;

	@Mock
	private AssignItemService assignItemService;

	@Mock
	private AssignItemRepository assignItemRepository;

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders
				.standaloneSetup(assignItemController).build();
	}

	@Test
	public void getAllAssignItemTest() throws Exception {
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

		List<AssignItem> itemList = new ArrayList<AssignItem>();
		itemList.add(assign);
		when(assignItemService.getAllAssignItem())
				.thenReturn(itemList);
		MvcResult mvcResult = this.mockMvc.perform(get("/AssignItem"))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(HttpStatus.OK.value(), status);

	}

	@Test
	public void getUnAssignedItemTest() throws Exception {
		int itemId = 1;
		String itemName = "itemName";
		String itemNumber = "itemNumber";
		String itemType = "itemType";
		String dateOfPurchase = "dateOfPurchase";
		String itemWarrantyPeriod = "itemWarrantyPeriod";
		String itemLocation = "itemLocation";
		String itemCondition = "itemCondition";
		boolean isItemAssigned = true;
		String incidentsIfAny = "incidentsIfAny";

		Item item = buildItem(itemId, itemName, itemNumber, itemType,
				dateOfPurchase, itemWarrantyPeriod, itemLocation,
				itemCondition, isItemAssigned, incidentsIfAny);

		List<Item> itemList = new ArrayList<Item>();
		itemList.add(item);
		when(assignItemService.getUnAssignedItem())
				.thenReturn(itemList);
		MvcResult mvcResult = this.mockMvc
				.perform(get("/UnAssignedItem")).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(HttpStatus.OK.value(), status);

	}

	@Test
	public void allAssignedItemTest() throws Exception {
		int id = 7;
		String employeeId = "N0011";
		String firstName = "piyush";
		String lastName = "raghuwanshi";
		String email = "piyush@gmail.com";
		int itemtableId = 5;
		int employeeTableId = 4;
		String itemName = "itemName";
		String itemNumber = "itemNumber";
		String itemCondition = "itemCondition";
		String incidentsIfAny = "incidentsIfAny";
		String dateOfAssigned = "9/33/039";

		AssignItemDtoOut assignItem = buildItem(id, itemtableId,
				employeeTableId, employeeId, firstName, lastName,
				email, itemCondition, dateOfAssigned, itemName,
				itemNumber, incidentsIfAny);

		List<AssignItemDtoOut> itemList = new ArrayList<AssignItemDtoOut>();
		itemList.add(assignItem);
		when(assignItemService.allAssignedItem())
				.thenReturn(itemList);
		MvcResult mvcResult = this.mockMvc
				.perform(get("/AllAssignedItem")).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(HttpStatus.OK.value(), status);

	}

	@Test
	public void itemDeletetest() throws Exception {
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

		ObjectMapper objectMapper = new ObjectMapper();
		String inputJSON = objectMapper.writeValueAsString(assign);
		AdminDtoOut adminDtoOut = new AdminDtoOut();
		adminDtoOut.setEmployeeMessage("Item Deleted Successfuly");
		when(assignItemService.deleteItem(6)).thenReturn(adminDtoOut);

		MvcResult mvcResult = this.mockMvc
				.perform(delete("/AssignItem/delete/6")
						.contentType(MediaType.APPLICATION_JSON)
						.content(inputJSON))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(HttpStatus.OK.value(), status);

	}

	@Test
	public void assignItemTest() throws Exception {
		MockitoAnnotations.openMocks(this);

		int itemtableId = 39;
		int employeeTableId = 60;
		String employeeId = "N0033";
		String itemReceivedAt = "Home";
		String assignedDate = "28/09/2000";

		AssignItemDtoIn assign = buildAssignItem(itemtableId,
				employeeTableId, employeeId, itemReceivedAt,
				assignedDate);
		List<AssignItemDtoIn> itemList = new ArrayList<AssignItemDtoIn>();
		itemList.add(assign);
		AdminDtoOut adminDtoOut = new AdminDtoOut();
		adminDtoOut.setEmployeeMessage("Item Assigned Successfuly");
		Mockito.when(assignItemService.assignItem(itemList))
				.thenReturn(adminDtoOut);

		ObjectMapper objectMapper = new ObjectMapper();
		String inputJSON = objectMapper.writeValueAsString(itemList);

		MvcResult mvcResult = this.mockMvc.perform(post("/AssignItem")
				.contentType(MediaType.APPLICATION_JSON)
				.content(inputJSON)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(HttpStatus.OK.value(), status);
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

	public AssignItemDtoIn buildAssignItem(int itemtableId,
			int employeeTableId, String employeeId,
			String itemReceivedAt, String assignedDate) {
		AssignItemDtoIn assign = new AssignItemDtoIn();

		assign.setItemtableId(itemtableId);
		assign.setEmployeeTableId(employeeTableId);
		assign.setEmployeeId(employeeId);
		assign.setItemReceivedAt(itemReceivedAt);
		assign.setAssignedDate(assignedDate);

		return assign;

	}

	public AssignItemDtoOut buildItem(int id, int itemtableId,
			int employeeTableId, String employeeId, String firstName,
			String lastName, String email, String itemCondition,
			String itemName, String itemNumber, String incidentsIfAny,
			String dateOfAssigned) {
		AssignItemDtoOut assign = new AssignItemDtoOut();

		assign.setId(id);
		assign.setFirstName(firstName);
		assign.setLastName(lastName);
		assign.setEmail(email);
		assign.setEmployeeId(employeeId);
		assign.setItemName(itemName);
		assign.setItemNumber(itemNumber);
		assign.setItemCondition(itemCondition);
		assign.setIncidentsIfAny(incidentsIfAny);
		assign.setItemTableId(itemtableId);
		assign.setEmployeeTableId(employeeTableId);
		assign.setDateOfAssigned(dateOfAssigned);
		return assign;

	}

}
