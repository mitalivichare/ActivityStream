package com.stackroute.activitystream;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stackroute.activitystream.dao.MessageDAO;
import com.stackroute.activitystream.model.Message;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT,classes=ActivityStreamBackendApplication.class)
@SpringBootApplication(scanBasePackages={"com.stackroute.activitystream"})
public class MessageTest {

	@Autowired
	private Message message;
	
	@Autowired
	private MessageDAO messageDAO;
	
	/*@BeforeClass
	public static void init()
	{
		message = new Message();
	}*/
	
	@Test
	public void sendMessageToUserTest() {
		message.setMessageContent("hello");
		message.setMessageType("Text");
		message.setSenderEmailId("shivani@gmail.com");
		message.setReceiverUserId("sayali@gmail.com");
		assertEquals(true, messageDAO.sendMessageToUser(message));
		
	}
	
	@Test
	public void sendMessageToCircleTest() {
		message.setMessageContent("Welcome to the group..");
		message.setMessageType("Text");
		message.setSenderEmailId("shivani@gmail.com");
		message.setCircleId(1);
		assertEquals(true, messageDAO.sendMessageToCircle(message));
		
	}

	//@Test
	public void getMessagesForUserTest()
	{
		List<Message> allUserMessages;
		allUserMessages = messageDAO.getMessagesForUser("");
		assertNotNull(allUserMessages);
		System.out.println(allUserMessages);
	}
	
	//@Test
	public void getMessagesForCircleTest()
	{
		List<Message> allCircleMessages;
		allCircleMessages = messageDAO.getMessagesForCircle(5);
		assertNotNull(allCircleMessages);
		System.out.println(allCircleMessages);
	}

}
