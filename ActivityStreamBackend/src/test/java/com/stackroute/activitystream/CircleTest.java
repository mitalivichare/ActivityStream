package com.stackroute.activitystream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stackroute.activitystream.dao.CircleDAO;
import com.stackroute.activitystream.model.Circle;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT,classes=ActivityStreamBackendApplication.class)
@SpringBootApplication(scanBasePackages={"com.stackroute.activitystream"})
public class CircleTest {
	//@Autowired
		private static Circle circle;
		
		@Autowired
		private CircleDAO circleDAO;


		@BeforeClass
		public static void init() {
			
			circle=new Circle();
		}
		
		@Test
		public void createCircleTest()
		{
			circle.setCircleName("Re-boot");
			circle.setCircleOwner("lisa@gmail.com");
			circle.setCircleDescription("The Re-boot gang");
			//circle.setCircleCreationDate();
			assertEquals(true, circleDAO.createCircle(circle));
		}
		
		//@Test
		public void updateCircle()
		{
			circle=circleDAO.getCircleByCircleId(2);
			circle.setCircleStatus("A");
			//circle.setCircleDescription("The Ghoooost Gang");
			assertEquals(true,circleDAO.updateCircle(circle));
		}
		
		//@Test
		public void deleteCircle()
		{
			assertEquals("Circle Deleted Successfully", true, circleDAO.deleteCircle(2));
		}
		
		//@Test
		public void getCircleByCircleId()
		{
			//assertEquals("Fetching Circle by ID Test Successfull", "ReBoot", circleDAO.getCircleByCircleId(2).getCircleName());
			circle=circleDAO.getCircleByCircleId(4);
			assertNotNull(circle);
			display("GetCircleByCircleId",circle);
		}
		
		//@Test
		public void getCircleByCircleName()
		{
			circle=circleDAO.getCircleByCircleName("Boot");
			assertNotNull(circle);
			display("GetCircleByCircleName",circle);
		}
		
		//@Test
		public void getAllCirclesTest()
		{
			List<Circle> circleList=circleDAO.getAllCircles();
			assertNotNull(circleList);
			System.out.println("List of Circles Available");
			System.out.println("========================================");
			for(Circle circle : circleList)
			{
				System.out.println(circle);;
			}
		}
		
		public void display(String methodName,Circle circle)
		{
			System.out.println(methodName);
			System.out.println("===========================================");
			System.out.println(circle);
		}


		//@Test
		public void contextLoads() {
		}

}
