package com.capstone.inventorymanagement.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capstone.inventorymanagement.dto.AdminDtoOut;
import com.capstone.inventorymanagement.dto.ItemDtoIn;
import com.capstone.inventorymanagement.dto.ItemDtoOut;
import com.capstone.inventorymanagement.dto.UpdateDtoIn;
import com.capstone.inventorymanagement.dto.UpdateItemDtoIn;
import com.capstone.inventorymanagement.repository.ItemRepository;
import com.capstone.inventorymanagement.service.ItemService;
import com.fasterxml.jackson.databind.ObjectMapper;

@MockitoSettings(strictness = Strictness.LENIENT)
@ExtendWith(MockitoExtension.class)
public class ItemControllerTest {
	@Mock
	private ItemService itemService;

	@Mock
	private ItemRepository itemRepository;

	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	private ItemController itemController;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(itemController)
				.build();
	}

	@Test
	public void addItemTest() throws Exception {
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

		ItemDtoIn itemDto = buildItemDto(itemId, itemName, itemNumber,
				itemType, dateOfPurchase, itemWarrantyPeriod,
				itemLocation, itemCondition, isItemAssigned,
				incidentsIfAny);
		ItemDtoOut itemDtoOut = new ItemDtoOut();
		itemDtoOut.setMessage("Item added successfully");

		Mockito.when(itemService.addItem(itemDto))
				.thenReturn(itemDtoOut);

		ObjectMapper objectMapper = new ObjectMapper();
		String inputJSON = objectMapper.writeValueAsString(itemDto);

		MvcResult mvcResult = this.mockMvc.perform(
				post("/item").contentType(MediaType.APPLICATION_JSON)
						.content(inputJSON))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

	@Test
	public void updateItemTest() throws Exception {
		MockitoAnnotations.openMocks(this);
		int itemId = 1;
		String itemName = "itemName";
		String itemType = "itemType";
		String dateOfPurchase = "dateOfPurchase";
		String itemWarrantyPeriod = "itemWarrantyPeriod";
		String itemLocation = "itemLocation";
		String itemCondition = "itemCondition";
		boolean isItemAssigned = false;
		String incidentsIfAny = "incidentsIfAny";

		UpdateItemDtoIn updateItemDtoIn = new UpdateItemDtoIn(itemId,
				itemName, itemType, dateOfPurchase,
				itemWarrantyPeriod, itemLocation, itemCondition,
				isItemAssigned, incidentsIfAny);

		ItemDtoOut itemDtoOut = new ItemDtoOut();
		itemDtoOut.setMessage("Item Updated successfully");
		Mockito.when(itemService.updateItem(updateItemDtoIn))
				.thenReturn(itemDtoOut);

		ObjectMapper objectMapper = new ObjectMapper();
		String inputJSON = objectMapper
				.writeValueAsString(updateItemDtoIn);

		MvcResult mvcResult = this.mockMvc.perform(
				put("/item").contentType(MediaType.APPLICATION_JSON)
						.content(inputJSON))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(HttpStatus.OK.value(), status);
	}
//	@Test
//	public void addItemNegativeTest() throws Exception {
//    	MockitoAnnotations.openMocks(this);
//    	 
//		int itemId = 1;
//		String itemName = "itemName";
//		String itemNumber = "itemNumber";
//		String itemType = "itemType";
//		String dateOfPurchase = "dateOfPurchase";
//		String itemWarrantyPeriod = "itemWarrantyPeriod"; 
//		String itemLocation = "itemLocation";
//		String itemCondition = "itemCondition";
//		boolean isItemAssigned =false;
//		String incidentsIfAny = "incidentsIfAny";
//		
//		
//       
//        ItemDtoIn itemDto = buildItemDto(itemId, itemName,itemNumber,itemType,dateOfPurchase,itemWarrantyPeriod,itemLocation,itemCondition,isItemAssigned,incidentsIfAny);
//        ItemDtoOut itemDtoOut = new ItemDtoOut();
//		itemDtoOut.setMessage("Item Already Exist");
//
//        Mockito.when(itemService.addItem(itemDto)).thenReturn(itemDtoOut);
//        
//		  ObjectMapper objectMapper = new ObjectMapper();
//	      String inputJSON = objectMapper.writeValueAsString(itemDto);
//	     
//		  MvcResult mvcResult = this.mockMvc.perform(post("/item")
//	              .contentType(MediaType.APPLICATION_JSON).content(inputJSON)).andReturn();
//	      int status = mvcResult.getResponse().getStatus();
//	      assertEquals(400, status);		
//	}

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
