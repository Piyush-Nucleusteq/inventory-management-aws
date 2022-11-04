package com.capstone.inventorymanagement.dto;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.capstone.inventorymanagement.domain.AssignItem;

public class AssignItemDtoOutTest {
	@Test
	public void assignItemDtoOutTest() {
		AssignItemDtoOut assign = new AssignItemDtoOut();
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

		assertEquals(id, assign.getId());
		assertEquals(itemtableId, assign.getItemTableId());
		assertEquals(employeeTableId, assign.getEmployeeTableId());
		assertEquals(employeeId, assign.getEmployeeId());
		assertEquals(email, assign.getEmail());
		assertEquals(firstName, assign.getFirstName());
		assertEquals(lastName, assign.getLastName());
		assertEquals(employeeId, assign.getEmployeeId());
		assertEquals(itemName, assign.getItemName());
		assertEquals(itemNumber, assign.getItemNumber());
		assertEquals(itemCondition, assign.getItemCondition());
		assertEquals(incidentsIfAny, assign.getIncidentsIfAny());
		assertEquals(dateOfAssigned, assign.getDateOfAssigned());

	}

	@Test
	public void testToString() {

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

		AssignItemDtoOut assign = buildItem(id, itemtableId,
				employeeTableId, employeeId, firstName, lastName,
				email, itemCondition, dateOfAssigned, itemName,
				itemNumber, incidentsIfAny);
		assertNotNull(assign.toString());
		System.out.println(assign.toString());
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
