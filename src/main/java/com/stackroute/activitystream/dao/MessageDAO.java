package com.stackroute.activitystream.dao;

import java.util.List;

import com.stackroute.activitystream.model.Message;

public interface MessageDAO {
	
	boolean sendMessageToCircle(Message message);

	boolean sendMessageToUser(Message message);

	List<Message> getMessagesForUser(String emailId);

	List<Message> getMessagesForCircle(int circleId);


}
