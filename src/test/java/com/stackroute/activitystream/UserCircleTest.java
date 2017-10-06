package com.stackroute.activitystream;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.activitystream.dao.UserCircleDAO;
import com.stackroute.activitystream.model.UserCircle;

public class UserCircleTest {

	private static UserCircle usercircle;
	
	@Autowired
	private UserCircleDAO usercircleDAO;
	
	@BeforeClass
	public static void init()
	{
		usercircle= new UserCircle();
	}
	
	@Test
	public void addUserToCircleTest()
	{
		//usercircle.setCircleId(1);
		//usercircle.setEmailId("sayali@gmail.com");
		assertEquals(true, usercircleDAO.addUserToCircle(1,"sayali@gmail.com"));
		
	}
	
	//@Test
	public void removeUserFromCircleTest()
	{
		assertEquals(true, usercircleDAO.removeUserFromCircle(1, "sayali@gmail.com"));
	}

}
