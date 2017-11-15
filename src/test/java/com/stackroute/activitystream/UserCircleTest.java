package com.stackroute.activitystream;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stackroute.activitystream.dao.UserCircleDAO;
import com.stackroute.activitystream.dao.UserCircleDAOImpl;
import com.stackroute.activitystream.model.UserCircle;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT,classes=ActivityStreamBackendApplication.class)
@SpringBootApplication(scanBasePackages={"com.stackroute.activitystream"})
public class UserCircleTest {
	
	@Autowired
	private UserCircle userCircle;
	
	@Autowired
	private UserCircleDAO userCircleDAO;
	
	/*@Before
	public void init()
	{
		userCircleDAO= new UserCircleDAOImpl();
		}*/
	
	@Test
	public void addUserToCirclePositiveTest()
	{
		//usercircle.setCircleId(1);
		//usercircle.setEmailId("sayali@gmail.com");
		assertEquals(true, userCircleDAO.addUserToCircle(5,"priti@gmail.com"));
		
	}		 
	
	//@Test
	public void addUserToCircleNegativeTest()
	{
		//usercircle.setCircleId(1);
		//usercircle.setEmailId("sayali@gmail.com");
		assertEquals(false, userCircleDAO.addUserToCircle(2,"sejal@gmail.com"));
		
	}
	
	//@Test
	public void removeUserFromCirclePositiveTest()
	{
		assertEquals(true, userCircleDAO.removeUserFromCircle(2, "kirti@gmail.com"));
	}
	
	//@Test
	public void removeUserFromCircleNegativeTest()
	{
		assertEquals(false, userCircleDAO.removeUserFromCircle(2, "sejal@gmail.com"));
	}

}
