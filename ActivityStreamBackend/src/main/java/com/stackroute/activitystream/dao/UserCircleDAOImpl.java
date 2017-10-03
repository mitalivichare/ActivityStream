package com.stackroute.activitystream.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.activitystream.model.UserCircle;

public class UserCircleDAOImpl implements UserCircleDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	UserCircle userCircle;
	
	
	public UserCircleDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	public boolean addUserToCircle(int circleId, String emailId) {
		// TODO Auto-generated method stub
		try
		{
			UserCircle userSubscription=getUserCircle(circleId, emailId);
			if(userSubscription == null)
			{
				userCircle.setCircleId(circleId);
				userCircle.setEmailId(emailId);
				userCircle.setSubscriptionDate();
				userCircle.setSubscriptionStatus("A");
				sessionFactory.getCurrentSession().save(userCircle);
				return true;
			}
			else
			{
				userCircle.setSubscriptionStatus("A");
				sessionFactory.getCurrentSession().update(userSubscription);
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
			if(userCircle != null)
			{
				userCircle.setSubscriptionStatus("N");
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
	
	
	//What is the use of this method?
	
	@SuppressWarnings("rawtypes")
	private UserCircle getUserCircle(int circleId,String emailId)
	{
		try
		{
		Query query=sessionFactory.getCurrentSession().createQuery("from UserCircle where circleId=? and emailId=? and subscriptionStatus=?");
		query.setParameter(0, circleId);
		query.setParameter(1, emailId);
		query.setParameter(2, "A");
		UserCircle userCircle=(UserCircle) query.uniqueResult();
		return userCircle;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	

}
