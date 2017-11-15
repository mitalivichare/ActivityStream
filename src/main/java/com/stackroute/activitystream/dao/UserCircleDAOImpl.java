package com.stackroute.activitystream.dao;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.activitystream.model.UserCircle;

@Repository("userCircleDAO")
@Transactional
public class UserCircleDAOImpl implements UserCircleDAO 
{
	private static Logger logger=LoggerFactory.getLogger(UserCircleDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	UserCircle userCircle;
	
	public UserCircleDAOImpl()
	{}
	
	public UserCircleDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	public boolean addUserToCircle(int circleId, String emailId) {
		// TODO Auto-generated method stub
		try
		{
			UserCircle userSubscription=getUserCircle(circleId, emailId);
			if(userSubscription != null && userSubscription.getSubscriptionStatus()=='A')
			{
				return false;
			}
			if(userSubscription == null)
			{
				userCircle.setCircleId(circleId);
				userCircle.setEmailId(emailId);
				userCircle.setSubscriptionDate();
				userCircle.setSubscriptionStatus('A');
				sessionFactory.getCurrentSession().save(userCircle);
				return true;
			}
			/*else
			{
				return false;
			}*/
			else
			{
				userCircle.setSubscriptionStatus('A');
				userCircle.setSubscriptionDate();
				sessionFactory.openSession().update(userCircle);
				return true;
			}
			
		}
		catch(Exception e)
		{
			return false;
		}
		

	}

	public boolean removeUserFromCircle(int circleId, String emailId) {
		// TODO Auto-generated method stub
		try
		{
			userCircle=getUserCircle(circleId, emailId);
			if(userCircle != null && userCircle.getSubscriptionStatus() =='A')
			{
				
				userCircle.setSubscriptionStatus('N');
				sessionFactory.getCurrentSession().update(userCircle);
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	//this method helps in getting the user's circle details while removing user from circle
	@SuppressWarnings("rawtypes")
	private UserCircle getUserCircle(int circleId,String emailId)
	{
		try
		{
		Query query=sessionFactory.getCurrentSession().createQuery("from UserCircle where circleId=? and emailId=?");
		query.setParameter(0, circleId);
		query.setParameter(1, emailId);
		//query.setParameter(2, 'A');
		UserCircle userCircle=(UserCircle) query.uniqueResult();
		return userCircle;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			return null;
		}
	}
	

}
