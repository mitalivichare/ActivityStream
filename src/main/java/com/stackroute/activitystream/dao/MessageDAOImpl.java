package com.stackroute.activitystream.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.activitystream.model.Message;

public class MessageDAOImpl implements MessageDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public MessageDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean sendMessageToCircle(Message message) {
		// TODO Auto-generated method stub
		try {
			message.setMessageDate(new Date());
			//message.setRecievingUserId(emailId);
			sessionFactory.getCurrentSession().save(message);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		//return false;
	}

	@Override
	public boolean sendMessageToUser(Message message) {
		// TODO Auto-generated method stub
		try {
			message.setMessageDate(new Date());
			//message.setRecievingUserId(emailId);
			sessionFactory.getCurrentSession().save(message);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		//return false;
	}

	@Override
	public List<Message> getMessagesByUser(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getMessagesByCircle(int circleId) {
		// TODO Auto-generated method stub
		return null;
	}

}
