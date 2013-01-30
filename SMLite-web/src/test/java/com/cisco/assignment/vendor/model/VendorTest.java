package com.cisco.assignment.vendor.model;

import static org.junit.Assert.assertEquals;

import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cisco.assignment.vendor.helper.HibernateUtil;


public class VendorTest  {
  private static Session session;
  
   @BeforeClass
   public static void initialze() {
	   session = HibernateUtil.getSessionFactory().openSession();
   }
	@Test
	public void testAddOrUpdateVendorRecord() {		
		
		//int id =1;
		String name = "test1";
		Vendor vendorObj = new Vendor(name, 1, "234", 1);	
		//session.beginTransaction();
		session.saveOrUpdate(vendorObj);
		//session.getTransaction().commit();
		
	    assertEquals("test1", name);	
		assertEquals("234", vendorObj.getPurchaseNumber());		
	}
	
	@Test
	public void testAddOrUpdateVendorObjRecord() {		
			
		Vendor vendorObj = new Vendor();
		vendorObj.setName("Vendor");
		vendorObj.setOrderType(2);
		vendorObj.setPurchaseNumber("111");
		vendorObj.setPurchaseOrderAvailable(1);
		
		//session.beginTransaction();
		session.saveOrUpdate(vendorObj);
		//session.getTransaction().commit();
		
	    assertEquals("Vendor", vendorObj.getName());
	    assertEquals(2, vendorObj.getOrderType());
	    assertEquals(true, vendorObj.isPurchaseOrderAvailable());
		assertEquals("111", vendorObj.getPurchaseNumber());	
		
		
	}

	/*@Test
	public void testVendorDetails() {
		int id =1;
		int orderType = 2;
		Vendor entity = new Vendor(id, "Cisco", true, "11111", 2);
		
		entity.setOrderType(0);
		assertNotSame(entity.getOrderType(),orderType);
	}*/

	@AfterClass
	public static void closeResources() {
		session.close();
	}

}
