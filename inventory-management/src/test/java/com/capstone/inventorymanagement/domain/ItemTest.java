package com.capstone.inventorymanagement.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class ItemTest {
	/**
	 * To test the user class
	 */
	@Test
	public void itemTest() {
		Item item = new Item();

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

		assertEquals(itemId, item.getItemId());
		assertEquals(itemName, item.getItemName());
		assertEquals(itemNumber, item.getItemNumber());
		assertEquals(itemType, item.getItemType());
		assertEquals(dateOfPurchase, item.getDateOfPurchase());
		assertEquals(itemWarrantyPeriod,
				item.getItemWarrantyPeriod());
		assertEquals(itemLocation, item.getItemLocation());
		assertEquals(itemCondition, item.getItemCondition());
		assertEquals(isItemAssigned, item.isItemAssigned());
		assertEquals(incidentsIfAny, item.getIncidentsIfAny());

	}

	@Test
	public void testGettersAndSetters() {
		Item item = new Item();

		assertNull(item.getItemId());
		int itemId = 1;
		;
		item.setItemId(itemId);
		assertEquals(itemId, item.getItemId());

		assertNull(item.getItemName());
		String itemName = "itemName";
		item.setItemName(itemName);
		assertEquals(itemName, item.getItemName());

		assertNull(item.getItemNumber());
		String itemNumber = "itemNumber";
		item.setItemNumber(itemNumber);
		assertEquals(itemNumber, item.getItemNumber());

		assertNull(item.getItemType());
		String itemType = "itemType";
		item.setItemType(itemType);
		assertEquals(itemType, item.getItemType());

		assertNull(item.getDateOfPurchase());
		String dateOfPurchase = "dateOfPurchase";
		item.setDateOfPurchase(dateOfPurchase);
		assertEquals(dateOfPurchase, item.getDateOfPurchase());

		assertNull(item.getItemWarrantyPeriod());
		String itemWarrantyPeriod = "itemWarrantyPeriod";
		item.setItemWarrantyPeriod(itemWarrantyPeriod);
		assertEquals(itemWarrantyPeriod,
				item.getItemWarrantyPeriod());

		assertNull(item.getItemLocation());
		String itemLocation = "itemLocation";
		item.setItemLocation(itemLocation);
		assertEquals(itemLocation, item.getItemLocation());

		boolean isItemAssigned = true;
		item.setIsItemAssigned(isItemAssigned);
		assertEquals(isItemAssigned, item.isItemAssigned());

		assertNull(item.getIncidentsIfAny());
		String incidentsIfAny = "incidentsIfAny";
		item.setIncidentsIfAny(incidentsIfAny);
		assertEquals(incidentsIfAny, item.getIncidentsIfAny());

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

		Item item = buildItem(itemId, itemName, itemNumber, itemType,
				dateOfPurchase, itemWarrantyPeriod, itemLocation,
				itemCondition, isItemAssigned, incidentsIfAny);
		assertNotNull(item.toString());
		System.out.println(item.toString());
	}

	@Test
	public void testEqualsAndHashCode() {

		Item item = new Item();

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

		Item item1 = buildItem(itemId, itemName, itemNumber, itemType,
				dateOfPurchase, itemWarrantyPeriod, itemLocation,
				itemCondition, isItemAssigned, incidentsIfAny);
		Item item2 = buildItem(itemId, itemName, itemNumber, itemType,
				dateOfPurchase, itemWarrantyPeriod, itemLocation,
				itemCondition, isItemAssigned, incidentsIfAny);

		assertEquals(item1, item2);
		assertEquals(item1, item1);
		assertEquals(false, item1.equals(null));
		assertEquals(false, item1.equals(item));
		System.out.println(item1.toString().hashCode());
		System.out.println(item1.toString().hashCode());
		assertEquals(item1.hashCode(), item2.hashCode());
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

}
