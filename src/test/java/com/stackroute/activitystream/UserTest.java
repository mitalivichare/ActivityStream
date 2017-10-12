package com.stackroute.activitystream;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stackroute.activitystream.dao.UserDAO;
import com.stackroute.activitystream.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT,classes=ActivityStreamBackendApplication.class)
@SpringBootApplication(scanBasePackages={"com.stackroute.activitystream"})
public class UserTest {

	//@Autowired
		private static User user;

		@Autowired
		private UserDAO userDAO;


		@BeforeClass
		public static void init() {
			user=new User();
		}

		/**
		 * 
		 */
		@Test(expected=DataIntegrityViolationException.class)
		public void createUserTest() {
			user.setFirstName("Shivani");
			user.setLastName("Vichare");
			user.setEmailId("shivani@gmail.com");
			user.setPassword("shivani");
			user.setContactNumber("9076095678");
			//user.setUserStatus("Active");
			assertEquals("Registration Successfull", true, userDAO.createUser(user));
		}
		
		  @Test
		  public void authenticateUserTest() 
		  {
			  user.setEmailId("sayali@gmail.com"); 
			  user.setPassword("sayali");
			  assertEquals("Login successfull", User.class,userDAO.authenticateUser(user).getClass());
		  }
		  
		  //@Test
		  public void deleteUserTest()
		  {
			  assertEquals("Delete User Test Successfull", true, userDAO.deleteUser("abc@gmail.com"));
		  }
		  
		  @Test
		  public void updateUserTestCase()
		  {
			user=userDAO.getUserByUserId("shivani@gmail.com");
			user.setContactNumber("85435643437");
			assertEquals("Update User Test Case Successfull", true,userDAO.updateUser(user));
		  }

}
