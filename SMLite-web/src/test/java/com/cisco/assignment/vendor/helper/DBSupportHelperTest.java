package com.cisco.assignment.vendor.helper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisco.assignment.vendor.model.OrderType;
import com.cisco.assignment.vendor.model.Vendor;

public class DBSupportHelperTest {

	static DBSupportHelper dbSupportHelper = null;
	@BeforeClass
	public static void initialize() throws ClassNotFoundException, SQLException {
		dbSupportHelper = DBSupportHelper.getInstance();
		dbSupportHelper.init();
	}
	
	@Test
	public void testGetOderTypes() {
		List <OrderType> orderTypeList = dbSupportHelper.getOderTypes();
		assertNotNull(orderTypeList);
		assertTrue(orderTypeList.size() > 0);
	}
	
	@Test
	public void testGetVendors() throws SQLException {
		List <Vendor> vendorList = dbSupportHelper.getVendors();
		assertNotNull(vendorList);		
	}
	
	@Test
	public void testAddOrUpdateVendorObjRecord() throws SQLException {
			
		Vendor vendorObj = new Vendor();
		vendorObj.setId(101);
		vendorObj.setName("Vendor");
		vendorObj.setOrderType(2);
		vendorObj.setPurchaseNumber("111");
		vendorObj.setPurchaseOrderAvailable(true);
		vendorObj.setCost(345344);
		int status = dbSupportHelper.addOrUpdateVendor(vendorObj);		
	    assertEquals(1, status);		
	}
	
	@Test
	public void testGetVendor() throws SQLException {
			
		Vendor vendorObj = new Vendor();
		vendorObj.setId(102);
		vendorObj.setName("Vendor");
		vendorObj.setOrderType(2);
		vendorObj.setPurchaseNumber("111");
		vendorObj.setPurchaseOrderAvailable(true);
		vendorObj.setCost(345379);
		dbSupportHelper.addOrUpdateVendor(vendorObj);
		assertNotNull(dbSupportHelper.getVendor(vendorObj.getId()));	    		
	}
	
	//@Test
	public void testDeleteVendor() throws SQLException {
			
		Vendor vendorObj = new Vendor();
		vendorObj.setId(103);
		vendorObj.setName("Vendor");
		vendorObj.setOrderType(2);
		vendorObj.setPurchaseNumber("111");
		vendorObj.setPurchaseOrderAvailable(true);
		vendorObj.setCost(565379);
		dbSupportHelper.addOrUpdateVendor(vendorObj);
		dbSupportHelper.deleteVendor(vendorObj.getId());
		assertNull(dbSupportHelper.getVendor(vendorObj.getId()));	    		
	}

}
