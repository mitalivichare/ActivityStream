package com.stackroute.activitystream.dao;

import java.util.List;

import com.stackroute.activitystream.model.Message;

public interface MessageDAO {
	
	boolean sendMessageToCircle(Message message);

	boolean sendMessageToUser(Message message);

	List<Message> getMessagesByUser(String emailId);

	List<Message> getMessagesByCircle(int circleId);


}
