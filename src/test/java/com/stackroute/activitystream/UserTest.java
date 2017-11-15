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

		@Autowired
		private User user;

		@Autowired
		private UserDAO userDAO;


		/*@BeforeClass
		public static void init() {
			user=new User();
		}
*/
		/**
		 * 
		 */
		@Test
		public void createUserPositiveTest() {
			user.setFirstName("Pooja");
			user.setLastName("Devi");
			user.setEmailId("kinjal@gmail.com");
			user.setPassword("pooja");
			user.setContactNumber("8086444678");
			//user.setUserStatus('A');
			assertEquals("Registration Successfull", true, userDAO.createUser(user));
		}
		
		@Test
		public void createUserNegativeTest() {
			user.setFirstName("Sapna");
			user.setLastName("Vichare");
			user.setEmailId("kirti@gmail.com");
			user.setPassword("sapna");
			user.setContactNumber("8086095678");
			//user.setUserStatus('A');
			assertEquals("Registration Un-Successfull", false, userDAO.createUser(user));
		}
		
		  @Test
		  public void authenticateUserTest() 
		  {
			  user.setEmailId("sayali@gmail.com"); 
			  user.setPassword("sayali");
			  assertEquals("Login successfull", User.class,userDAO.authenticateUser(user).getClass());
		  }
		  
		  @Test
		  public void deleteUserPositiveTest()
		  {
			  assertEquals("Delete User Test Successfull", true, userDAO.deleteUser("priti@gmail.com"));
		  }
		  
		  @Test
		  public void deleteUserNegativeTest()
		  {
			  assertEquals("Delete User Test Successfull", false, userDAO.deleteUser("sonam@gmail.com"));
		  }
		  
		  @Test
		  public void updateUserTestCase()
		  {
			user=userDAO.getUserByUserId("sonal@gmail.com");
			//user.setContactNumber("85435643437");
			user.setUserStatus('A');
			assertEquals("Update User Test Case Successfull", true,userDAO.updateUser(user));
		  }

}
