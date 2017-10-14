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
			//where you will create multiple records for each user?
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
			//Need to store the message in another table also like UserMessage
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
		try {
			List<Message> userMessages;
			//wrong query.  think and let me know.
			Query query = sessionFactory.getCurrentSession().createQuery("from Message where receiverUserId = ?");
			query.setParameter(0, emailId);
			userMessages = query.list();
			return userMessages;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		//return null;
	}

	@Override
	public List<Message> getMessagesByCircle(int circleId) {
		// TODO Auto-generated method stub
		try {
			List<Message> circleMessages;
			Query query = sessionFactory.getCurrentSession().createQuery("from Message where receiverCircleId = ?");
			
			//What if user want previously records/messages??
			query.setParameter(0, circleId);
			query.setMaxResults(10);
			circleMessages = query.list();
			return circleMessages;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		//return null;
	}

}
