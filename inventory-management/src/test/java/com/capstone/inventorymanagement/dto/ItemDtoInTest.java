package com.capstone.inventorymanagement.dto;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class ItemDtoInTest {

	/**
	 * To test the user class
	 */
	@Test
	public void itemDtoInTest() {
		ItemDtoIn itemDto = new ItemDtoIn();

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

		assertEquals(itemId, itemDto.getItemId());
		assertEquals(itemName, itemDto.getItemName());
		assertEquals(itemNumber, itemDto.getItemNumber());
		assertEquals(itemType, itemDto.getItemType());
		assertEquals(dateOfPurchase, itemDto.getDateOfPurchase());
		assertEquals(itemWarrantyPeriod,
				itemDto.getItemWarrantyPeriod());
		assertEquals(itemLocation, itemDto.getItemLocation());
		assertEquals(itemCondition, itemDto.getItemCondition());
		assertEquals(isItemAssigned, itemDto.isItemAssigned());
		assertEquals(incidentsIfAny, itemDto.getIncidentsIfAny());

	}

	@Test
	public void testGettersAndSetters() {
		ItemDtoIn itemDto = new ItemDtoIn();

		assertNull(itemDto.getItemId());
		int itemId = 1;
		;
		itemDto.setItemId(itemId);
		assertEquals(itemId, itemDto.getItemId());

		assertNull(itemDto.getItemName());
		String itemName = "itemName";
		itemDto.setItemName(itemName);
		assertEquals(itemName, itemDto.getItemName());

		assertNull(itemDto.getItemNumber());
		String itemNumber = "itemNumber";
		itemDto.setItemNumber(itemNumber);
		assertEquals(itemNumber, itemDto.getItemNumber());

		assertNull(itemDto.getItemType());
		String itemType = "itemType";
		itemDto.setItemType(itemType);
		assertEquals(itemType, itemDto.getItemType());

		assertNull(itemDto.getDateOfPurchase());
		String dateOfPurchase = "dateOfPurchase";
		itemDto.setDateOfPurchase(dateOfPurchase);
		assertEquals(dateOfPurchase, itemDto.getDateOfPurchase());

		assertNull(itemDto.getItemWarrantyPeriod());
		String itemWarrantyPeriod = "itemWarrantyPeriod";
		itemDto.setItemWarrantyPeriod(itemWarrantyPeriod);
		assertEquals(itemWarrantyPeriod,
				itemDto.getItemWarrantyPeriod());

		assertNull(itemDto.getItemLocation());
		String itemLocation = "itemLocation";
		itemDto.setItemLocation(itemLocation);
		assertEquals(itemLocation, itemDto.getItemLocation());

		boolean isItemAssigned = true;
		itemDto.setIsItemAssigned(isItemAssigned);
		assertEquals(isItemAssigned, itemDto.isItemAssigned());

		assertNull(itemDto.getIncidentsIfAny());
		String incidentsIfAny = "incidentsIfAny";
		itemDto.setIncidentsIfAny(incidentsIfAny);
		assertEquals(incidentsIfAny, itemDto.getIncidentsIfAny());

	}

	@Test
	public void testToString() {

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

		ItemDtoIn itemDto = buildItemDto(itemId, itemName, itemNumber,
				itemType, dateOfPurchase, itemWarrantyPeriod,
				itemLocation, itemCondition, isItemAssigned,
				incidentsIfAny);
		assertNotNull(itemDto.toString());
		System.out.println(itemDto.toString());
	}

	@Test
	public void testEqualsAndHashCode() {

		ItemDtoIn item = new ItemDtoIn();

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

		ItemDtoIn itemDto1 = buildItemDto(itemId, itemName,
				itemNumber, itemType, dateOfPurchase,
				itemWarrantyPeriod, itemLocation, itemCondition,
				isItemAssigned, incidentsIfAny);
		ItemDtoIn itemDto2 = buildItemDto(itemId, itemName,
				itemNumber, itemType, dateOfPurchase,
				itemWarrantyPeriod, itemLocation, itemCondition,
				isItemAssigned, incidentsIfAny);

		assertEquals(itemDto1, itemDto2);
		assertEquals(itemDto1, itemDto1);
		assertEquals(false, itemDto1.equals(null));
		assertEquals(false, itemDto1.equals(item));
		System.out.println(itemDto1.toString().hashCode());
		System.out.println(itemDto1.toString().hashCode());
		assertEquals(itemDto1.hashCode(), itemDto2.hashCode());
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
