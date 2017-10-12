package com.stackroute.activitystream.dao;

public interface UserCircleDAO 
{
	public boolean addUserToCircle(int circleId,String emailId);
	public boolean removeUserFromCircle(int circleId,String emailId);
	
	//get All circle method present in CircleDAO
	//get my circle method present in UserCircleDAOImpl as a private method

}
