package com.stackroute.activitystream.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.activitystream.model.Message;

@Repository("messageDAO")
@Transactional
public class MessageDAOImpl implements MessageDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public MessageDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public boolean sendMessageToUser(Message message) {
		// TODO Auto-generated method stub
		try {
			message.setMessageDate(new Date());
			//message.setRecievingUserId(emailId);
			message.setMaxSize(120);
			sessionFactory.getCurrentSession().save(message);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		//return false;
	}

	@Override
	public boolean sendMessageToCircle(Message message) {
		// TODO Auto-generated method stub
		try {
			message.setMessageDate(new Date());
			//message.setRecievingUserId(emailId);
			message.setMaxSize(120);
			sessionFactory.getCurrentSession().save(message);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		//return false;
	}

	

	@Override
	public List<Message> getMessagesForUser(String emailId) {
		// TODO Auto-generated method stub
		try {
			List<Message> userMessages;
			Query query = sessionFactory.getCurrentSession().createQuery("from Message where receiverUserId = ? or senderEmailId = ?");
			query.setParameter(0, emailId);
			query.setParameter(1, emailId);
			userMessages = query.list();
			return userMessages;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		//return null;
	}

	@Override
	public List<Message> getMessagesForCircle(int circleId) {
		// TODO Auto-generated method stub
		try {
			List<Message> circleMessages;
			Query query = sessionFactory.getCurrentSession().createQuery("from Message where circleId = ?");
			query.setParameter(0, circleId);
			//query.setMaxResults(10);
			circleMessages = query.list();
			return circleMessages;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		//return null;
	}

}
