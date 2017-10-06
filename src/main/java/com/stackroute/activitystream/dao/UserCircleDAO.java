package com.stackroute.activitystream.dao;

public interface UserCircleDAO 
{
	public boolean addUserToCircle(int circleId,String emailId);
	public boolean removeUserFromCircle(int circleId,String emailId);
	
	
	//get All circle method present in CircleDAO
	//get my circle method present in UserCircleDAOImpl as a private method
	
	//get my circles method should not be private.  It should be there in this interface also, so that it can be acces from outside.
	//i.e., from micro service.
	
	

}
