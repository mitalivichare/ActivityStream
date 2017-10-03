package com.stackroute.activitystream.dao;

public interface UserCircleDAO 
{
	public boolean addUserToCircle(int circleId,String emailId);
	public boolean removeUserFromCircle(int circleId,String emailId);
	
	//Need to add other methods  like
	// get My circles
	// get All Circles
	// get All Users related to particular circle etc.,

}
