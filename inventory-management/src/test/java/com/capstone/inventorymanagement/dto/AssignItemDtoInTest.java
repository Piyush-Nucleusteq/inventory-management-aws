package com.capstone.inventorymanagement.dto;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.capstone.inventorymanagement.domain.AssignItem;

public class AssignItemDtoInTest {
	@Test
	public void assignItemDtoInTest() {
		AssignItemDtoIn assign = new AssignItemDtoIn();
		int id = 6;
		int itemtableId = 5;
		int employeeTableId = 4;
		String employeeId = "N0033";
		String itemReceivedAt = "Home";
		String assignedDate = "28/09/2000";
		String createdAt = "993388";
		String updatedAt = "22/430/33";

		assign.setId(id);
		assign.setItemtableId(itemtableId);
		assign.setEmployeeTableId(employeeTableId);
		assign.setEmployeeId(employeeId);
		assign.setItemReceivedAt(itemReceivedAt);
		assign.setAssignedDate(assignedDate);
		assign.setCreatedAt(createdAt);
		assign.setUpdatedAt(updatedAt);

		assertEquals(id, assign.getId());
		assertEquals(itemtableId, assign.getItemtableId());
		assertEquals(employeeTableId, assign.getEmployeeTableId());
		assertEquals(employeeId, assign.getEmployeeId());
		assertEquals(itemReceivedAt, assign.getItemReceivedAt());
		assertEquals(assignedDate, assign.getAssignedDate());
		assertEquals(createdAt, assign.getCreatedAt());
		assertEquals(updatedAt, assign.getUpdatedAt());

	}

	@Test
	public void testGettersAndSetters() {

		AssignItemDtoIn assign = new AssignItemDtoIn();

		assertNull(assign.getId());

		assertNull(assign.getItemtableId());

		assertNull(assign.getEmployeeId());

		assertNull(assign.getEmployeeTableId());

		assertNull(assign.getItemReceivedAt());

		assertNull(assign.getAssignedDate());

		assertNull(assign.getCreatedAt());

		assertNull(assign.getUpdatedAt());

	}

	@Test
	public void testToString() {

		int id = 6;
		int itemtableId = 5;
		int employeeTableId = 4;
		String employeeId = "N0033";
		String itemReceivedAt = "Home";
		String assignedDate = "28/09/2000";
		String createdAt = "993388";
		String updatedAt = "22/430/33";

		AssignItemDtoIn assign = buildItem(id, itemtableId,
				employeeTableId, employeeId, itemReceivedAt,
				assignedDate, createdAt, updatedAt);
		assertNotNull(assign.toString());
		System.out.println(assign.toString());
	}

	@Test
	public void testEqualsAndHashCode() {
		AssignItem assign = new AssignItem();

		int id = 6;
		int itemtableId = 5;
		int employeeTableId = 4;
		String employeeId = "N0033";
		String itemReceivedAt = "Home";
		String assignedDate = "28/09/2000";
		String createdAt = "993388";
		String updatedAt = "22/430/33";

		AssignItemDtoIn assign1 = buildItem(id, itemtableId,
				employeeTableId, employeeId, itemReceivedAt,
				assignedDate, createdAt, updatedAt);
		AssignItemDtoIn assign2 = buildItem(id, itemtableId,
				employeeTableId, employeeId, itemReceivedAt,
				assignedDate, createdAt, updatedAt);
		Object obj = new Object();
		assertNotEquals(assign1, obj);
		assertEquals(assign1, assign2);
		assertEquals(assign1, assign1);
		assertEquals(false, assign1.equals(null));
		assertEquals(false, assign1.equals(assign));
		System.out.println(assign1.toString().hashCode());
		System.out.println(assign1.toString().hashCode());
		assertEquals(assign1.hashCode(), assign2.hashCode());
//         assign2 = buildItem(id,itemtableId,employeeTableId,employeeId+" ",itemReceivedAt,assignedDate,createdAt,updatedAt);
//        assertNotEquals(assign1.hashCode(),assign2.hashCode());
//        assign2 = buildItem(id,itemtableId,employeeTableId,employeeId,itemReceivedAt=" ",assignedDate,createdAt,updatedAt);
//        assertNotEquals(assign1.hashCode(),assign2.hashCode());
//        assign2 = buildItem(id,itemtableId,employeeTableId,employeeId,itemReceivedAt,assignedDate+" ",createdAt,updatedAt);
//        assertNotEquals(assign1.hashCode(),assign2.hashCode());
	}

	public AssignItemDtoIn buildItem(int id, int itemtableId,
			int employeeTableId, String employeeId,
			String itemReceivedAt, String assignedDate,
			String createdAt, String updatedAt) {
		AssignItemDtoIn assign = new AssignItemDtoIn();
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

}
