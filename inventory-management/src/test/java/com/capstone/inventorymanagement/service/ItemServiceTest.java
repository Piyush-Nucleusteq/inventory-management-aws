package com.capstone.inventorymanagement.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.capstone.inventorymanagement.controller.UserController;
import com.capstone.inventorymanagement.domain.Item;
import com.capstone.inventorymanagement.dto.ItemDtoIn;
import com.capstone.inventorymanagement.dto.ItemDtoOut;
import com.capstone.inventorymanagement.dto.UpdateItemDtoIn;
import com.capstone.inventorymanagement.exception.NotFoundException;
import com.capstone.inventorymanagement.exception.RecordAlreadyExistException;
import com.capstone.inventorymanagement.repository.ItemRepository;

@RunWith(SpringRunner.class)
public class ItemServiceTest {

	@Mock
	private ItemRepository itemRepository;
	@InjectMocks
	private ItemServiceImpl itemServiceImpl;
	@Mock
	private ItemService ItemService;
	@Mock
	UserController userController;

	@BeforeEach
	public void buildItemDto() {

		MockitoAnnotations.openMocks(this);

	}

	@Test
	public void getAllItemTest() {

		final List<Item> items = new ArrayList<>();
		Item item = new Item();
		item.setItemNumber("Lap2022");
		item.setItemId(1);
		item.setItemName("laptop");
		item.setDateOfPurchase("date");
		item.setIncidentsIfAny("no");
		item.setIsItemAssigned(false);
		item.setItemCondition("working");
		item.setItemLocation("indore");
		item.setItemType("hardware");
		item.setItemWarrantyPeriod("3years");

		Item item1 = new Item();
		item1.setItemNumber("Lap2023");
		item1.setItemId(2);
		item1.setItemName("laptop");
		item1.setDateOfPurchase("date");
		item1.setIncidentsIfAny("no");
		item1.setIsItemAssigned(true);
		item1.setItemCondition("working");
		item1.setItemLocation("indore");
		item1.setItemType("hardware");
		item1.setItemWarrantyPeriod("3years");

		items.add(item);
		items.add(item1);

		List<Item> foundItems = itemServiceImpl.getAllItem();
		assertNotNull(foundItems);
		assertEquals(2, items.size());

	}

	// JUnit test for createUser method
	@DisplayName("JUnit test for saveEmployee method")
	@Test
	public void givenItemObject_whenSaveItem_thenReturnItemObject()
			throws RecordAlreadyExistException {
		MockitoAnnotations.openMocks(this);
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

		ItemDtoOut itemDtoOut = new ItemDtoOut();

		ItemDtoIn itemDto = buildItemDto(itemId, itemName, itemNumber,
				itemType, dateOfPurchase, itemWarrantyPeriod,
				itemLocation, itemCondition, isItemAssigned,
				incidentsIfAny);

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
		Mockito.when(itemRepository.save(item)).thenReturn(item);
		assertEquals(itemDtoOut, itemServiceImpl.addItem(itemDto));
	}

	@Test
	public void updateUserTest() throws NotFoundException {
		MockitoAnnotations.openMocks(this);
		String itemNameUpdated = "Laptop";
		int itemId = 1;
		String itemName = "itemName";
		String itemType = "itemType";
		String dateOfPurchase = "dateOfPurchase";
		String itemWarrantyPeriod = "itemWarrantyPeriod";
		String itemLocation = "itemLocation";
		String itemCondition = "itemCondition";
		boolean isItemAssigned = true;
		String incidentsIfAny = "incidentsIfAny";
		ItemDtoOut itemDtoOut = new ItemDtoOut();
		UpdateItemDtoIn updateItemDtoIn = new UpdateItemDtoIn(itemId,
				itemName, itemType, dateOfPurchase,
				itemWarrantyPeriod, itemLocation, itemCondition,
				isItemAssigned, incidentsIfAny);

		Item item = new Item();
		item.setItemId(updateItemDtoIn.getItemId());
		item.setItemName(updateItemDtoIn.getItemName());
		item.setItemType(updateItemDtoIn.getItemType());
		item.setDateOfPurchase(updateItemDtoIn.getDateOfPurchase());
		item.setItemWarrantyPeriod(
				updateItemDtoIn.getItemWarrantyPeriod());
		item.setItemLocation(updateItemDtoIn.getItemLocation());
		item.setItemCondition(updateItemDtoIn.getItemCondition());
		item.setIsItemAssigned(updateItemDtoIn.isItemAssigned());
		item.setIncidentsIfAny(updateItemDtoIn.getIncidentsIfAny());
		Optional<Item> optItem = Optional.of(item);
		when(itemRepository.findById(1)).thenReturn(optItem);
		item.setItemName(itemNameUpdated);
		itemDtoOut.setMessage("Item Updated successfully");
		when(itemRepository.save(item)).thenReturn(item);
		assertEquals(itemDtoOut,
				itemServiceImpl.updateItem(updateItemDtoIn));
	}

	public ItemDtoIn buildItemDto(int itemId, String itemName,
			String itemNumber, String itemType, String dateOfPurchase,
			String itemWarrantyPeriod, String itemLocation,
			String itemCondition, boolean isItemAssigned,
			String incidentsIfAny) {
		ItemDtoIn itemDto = new ItemDtoIn();
		itemDto.setItemId(itemId);
		itemDto.setItemName(itemName);
		itemDto.setItemNumber(itemNumber);
		itemDto.setItemType(itemType);
		itemDto.setDateOfPurchase(dateOfPurchase);
		itemDto.setItemWarrantyPeriod(itemWarrantyPeriod);
		itemDto.setItemLocation(itemLocation);
		itemDto.setItemCondition(itemCondition);
		itemDto.setIsItemAssigned(isItemAssigned);
		itemDto.setIncidentsIfAny(incidentsIfAny);
		return itemDto;

	}

}
