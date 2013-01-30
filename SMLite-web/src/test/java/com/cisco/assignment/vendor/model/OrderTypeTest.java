package com.cisco.assignment.vendor.model;

import static org.junit.Assert.assertEquals;

import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cisco.assignment.vendor.helper.HibernateUtil;




public class OrderTypeTest  {
  private static Session session;
  
   @BeforeClass
   public static void initialze() {
	  session = HibernateUtil.getSessionFactory().openSession();
   }
	@Test
	public void testAddOrUpdateOrderTypeRecord() {		
		
		OrderType orderType = new OrderType(5, "OrderTypeTest");
		//session.beginTransaction();
		session.saveOrUpdate(orderType);
		//session.getTransaction().commit();
	    assertEquals(5, orderType.getId());	
		assertEquals("OrderTypeTest", orderType.getName());			
	}	

	@Test
	public void testAddOrUpdateOrderTypeObjRecord() {		
		
		OrderType orderType = new OrderType();
		orderType.setId(6);
		orderType.setName("Test");
		session.saveOrUpdate(orderType);
		assertEquals(6, orderType.getId());	
		assertEquals("Test", orderType.getName());			
	}
	
	@AfterClass
	public static void closeResources() {
		session.close();
	}

}
