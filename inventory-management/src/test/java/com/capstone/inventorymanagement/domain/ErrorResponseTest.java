package com.capstone.inventorymanagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ErrorResponseTest {

	@Test
	public void errorResponseTest() {
		String message1 = "9823727283";
		Integer status = HttpStatus.OK.value();

		List<String> messageList = new ArrayList<String>();
		messageList.add(message1);

		ErrorResponse errorResponse = new ErrorResponse(status,
				messageList);

		errorResponse.setStatus(HttpStatus.OK.value());
		errorResponse.setMessages(messageList);

		assertEquals(status, errorResponse.getStatus());
		assertEquals(messageList, errorResponse.getMessages());

		errorResponse.toString();
	}
}
