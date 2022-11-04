package com.capstone.inventorymanagement.dto;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class UpdateItemDtoInTest {
	@Test
	public void updateItemDtoInTest() {
		UpdateItemDtoIn updateItemDtoIn = new UpdateItemDtoIn();

		int itemId = 1;
		String itemName = "itemName";
		String itemType = "itemType";
		String dateOfPurchase = "dateOfPurchase";
		String itemWarrantyPeriod = "itemWarrantyPeriod";
		String itemLocation = "itemLocation";
		String itemCondition = "itemCondition";
		boolean isItemAssigned = true;
		String incidentsIfAny = "incidentsIfAny";

		updateItemDtoIn.setItemId(itemId);
		updateItemDtoIn.setItemName(itemName);
		updateItemDtoIn.setItemType(itemType);
		updateItemDtoIn.setDateOfPurchase(dateOfPurchase);
		updateItemDtoIn.setItemWarrantyPeriod(itemWarrantyPeriod);
		updateItemDtoIn.setItemLocation(itemLocation);
		updateItemDtoIn.setItemCondition(itemCondition);
		updateItemDtoIn.setIsItemAssigned(isItemAssigned);
		updateItemDtoIn.setIncidentsIfAny(incidentsIfAny);

		assertEquals(itemId, updateItemDtoIn.getItemId());
		assertEquals(itemName, updateItemDtoIn.getItemName());
		assertEquals(itemType, updateItemDtoIn.getItemType());
		assertEquals(dateOfPurchase,
				updateItemDtoIn.getDateOfPurchase());
		assertEquals(itemWarrantyPeriod,
				updateItemDtoIn.getItemWarrantyPeriod());
		assertEquals(itemLocation, updateItemDtoIn.getItemLocation());
		assertEquals(itemCondition,
				updateItemDtoIn.getItemCondition());
		assertEquals(isItemAssigned,
				updateItemDtoIn.isItemAssigned());
		assertEquals(incidentsIfAny,
				updateItemDtoIn.getIncidentsIfAny());

	}

	@Test
	public void testGettersAndSettersUpdateItem() {
		UpdateItemDtoIn updateItemDtoIn = new UpdateItemDtoIn();

		assertNull(updateItemDtoIn.getItemId());
		int itemId = 1;
		;
		updateItemDtoIn.setItemId(itemId);
		assertEquals(itemId, updateItemDtoIn.getItemId());

		assertNull(updateItemDtoIn.getItemName());
		String itemName = "itemName";
		updateItemDtoIn.setItemName(itemName);
		assertEquals(itemName, updateItemDtoIn.getItemName());

		assertNull(updateItemDtoIn.getItemType());
		String itemType = "itemType";
		updateItemDtoIn.setItemType(itemType);
		assertEquals(itemType, updateItemDtoIn.getItemType());

		assertNull(updateItemDtoIn.getDateOfPurchase());
		String dateOfPurchase = "dateOfPurchase";
		updateItemDtoIn.setDateOfPurchase(dateOfPurchase);
		assertEquals(dateOfPurchase,
				updateItemDtoIn.getDateOfPurchase());

		assertNull(updateItemDtoIn.getItemWarrantyPeriod());
		String itemWarrantyPeriod = "itemWarrantyPeriod";
		updateItemDtoIn.setItemWarrantyPeriod(itemWarrantyPeriod);
		assertEquals(itemWarrantyPeriod,
				updateItemDtoIn.getItemWarrantyPeriod());

		assertNull(updateItemDtoIn.getItemLocation());
		String itemLocation = "itemLocation";
		updateItemDtoIn.setItemLocation(itemLocation);
		assertEquals(itemLocation, updateItemDtoIn.getItemLocation());

		boolean isItemAssigned = true;
		updateItemDtoIn.setIsItemAssigned(isItemAssigned);
		assertEquals(isItemAssigned,
				updateItemDtoIn.isItemAssigned());

		assertNull(updateItemDtoIn.getIncidentsIfAny());
		String incidentsIfAny = "incidentsIfAny";
		updateItemDtoIn.setIncidentsIfAny(incidentsIfAny);
		assertEquals(incidentsIfAny,
				updateItemDtoIn.getIncidentsIfAny());

	}

	@Test
	public void testToString() {

		int itemId = 1;
		String itemName = "itemName";
		String itemType = "itemType";
		String dateOfPurchase = "dateOfPurchase";
		String itemWarrantyPeriod = "itemWarrantyPeriod";
		String itemLocation = "itemLocation";
		String itemCondition = "itemCondition";
		boolean isItemAssigned = true;
		String incidentsIfAny = "incidentsIfAny";

		UpdateItemDtoIn updateItemDtoIn1 = buildUpdateItemDtoIn(
				itemId, itemName, itemType, dateOfPurchase,
				itemWarrantyPeriod, itemLocation, itemCondition,
				isItemAssigned, incidentsIfAny);
		assertNotNull(updateItemDtoIn1.toString());
		System.out.println(updateItemDtoIn1.toString());
	}

	@Test
	public void testEqualsAndHashCode() {

		ItemDtoIn item = new ItemDtoIn();

		int itemId = 1;
		String itemName = "itemName";
		String itemType = "itemType";
		String dateOfPurchase = "dateOfPurchase";
		String itemWarrantyPeriod = "itemWarrantyPeriod";
		String itemLocation = "itemLocation";
		String itemCondition = "itemCondition";
		boolean isItemAssigned = true;
		String incidentsIfAny = "incidentsIfAny";

		UpdateItemDtoIn updateItemDtoIn1 = buildUpdateItemDtoIn(
				itemId, itemName, itemType, dateOfPurchase,
				itemWarrantyPeriod, itemLocation, itemCondition,
				isItemAssigned, incidentsIfAny);
		UpdateItemDtoIn updateItemDtoIn2 = buildUpdateItemDtoIn(
				itemId, itemName, itemType, dateOfPurchase,
				itemWarrantyPeriod, itemLocation, itemCondition,
				isItemAssigned, incidentsIfAny);

		assertEquals(updateItemDtoIn1, updateItemDtoIn2);
		assertEquals(updateItemDtoIn1, updateItemDtoIn1);
		assertEquals(false, updateItemDtoIn1.equals(null));
		assertEquals(false, updateItemDtoIn1.equals(item));
		System.out.println(updateItemDtoIn1.toString().hashCode());
		System.out.println(updateItemDtoIn1.toString().hashCode());
		assertEquals(updateItemDtoIn1.hashCode(),
				updateItemDtoIn2.hashCode());
	}

	public UpdateItemDtoIn buildUpdateItemDtoIn(int itemId,
			String itemName, String itemType, String dateOfPurchase,
			String itemWarrantyPeriod, String itemLocation,
			String itemCondition, boolean isItemAssigned,
			String incidentsIfAny) {
		UpdateItemDtoIn updateItemDtoIn = new UpdateItemDtoIn();

		updateItemDtoIn.setItemId(itemId);
		updateItemDtoIn.setItemName(itemName);
		updateItemDtoIn.setItemType(itemType);
		updateItemDtoIn.setDateOfPurchase(dateOfPurchase);
		updateItemDtoIn.setItemWarrantyPeriod(itemWarrantyPeriod);
		updateItemDtoIn.setItemLocation(itemLocation);
		updateItemDtoIn.setItemCondition(itemCondition);
		updateItemDtoIn.setIsItemAssigned(isItemAssigned);
		updateItemDtoIn.setIncidentsIfAny(incidentsIfAny);
		return updateItemDtoIn;

	}

}
