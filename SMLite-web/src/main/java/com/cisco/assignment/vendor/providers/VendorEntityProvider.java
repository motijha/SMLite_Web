package com.cisco.assignment.vendor.providers;

import static com.cisco.assignment.vendor.helper.Constants.ENTITY_PREFIX_VENDOR;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.sakaiproject.entitybus.EntityReference;

import org.sakaiproject.entitybus.entityprovider.CoreEntityProvider;
import org.sakaiproject.entitybus.entityprovider.EntityProviderManager;

import org.sakaiproject.entitybus.entityprovider.capabilities.RESTful;
import org.sakaiproject.entitybus.entityprovider.extension.Formats;
import org.sakaiproject.entitybus.entityprovider.search.Search;
import org.sakaiproject.entitybus.exception.EntityException;
import org.sakaiproject.entitybus.exception.EntityNotFoundException;
import org.sakaiproject.entitybus.util.AbstractAutoRegisteringProvider;


import com.cisco.assignment.vendor.helper.DBSupportHelper;
import com.cisco.assignment.vendor.model.Vendor;


/**
 * Defines RESTful services for Vendor CRUD operation.
 * 
 * 
 */
public class VendorEntityProvider extends AbstractAutoRegisteringProvider
		implements CoreEntityProvider, RESTful {
	
	/*  Logger reference */
	static Logger LOG = Logger.getLogger(VendorEntityProvider.class.getName());
	
	public VendorEntityProvider(EntityProviderManager entityProviderManager) {
		super(entityProviderManager);
	}

	public String getEntityPrefix() {
		return ENTITY_PREFIX_VENDOR;
	}

	public Object getSampleEntity() {
		return new Vendor();
	}

	public Object getEntity(EntityReference ref) {
		Vendor vendor = null;
		String msg = null;
		try {
			vendor = DBSupportHelper.getInstance().getVendor(
					Integer.parseInt(ref.getId()));
			if (vendor == null) {
				msg = "Couldn't find the vendor.";
			}
		} catch (NumberFormatException e) {
			LOG.info("Error parsing the vendor id.");			
		} catch (SQLException e) {
			LOG.info("Error while retrieving the vendor."+e);		
		}
		if (vendor == null) {			
			LOG.info(msg);			
			throw new EntityNotFoundException(msg, ref.getId());
		}
		return vendor;
	}

	public List<?> getEntities(EntityReference ref, Search search) {
		List<Vendor> vendors = null;
		try {
			vendors = DBSupportHelper.getInstance().getVendors();
			return vendors;
		} catch (SQLException e) {
			String msg = "Error while retrieving vendors.";
			System.err.println(msg);
			throw new EntityException(msg, ref.getId());
		}
	}

	public String createEntity(EntityReference ref, Object entity,
			Map<String, Object> params) {
		Vendor vendor = (Vendor) entity;
		DBSupportHelper dbHelper = DBSupportHelper.getInstance();
		if (!vendor.isPurchaseOrderAvailable()) {
			vendor.setPurchaseNumber("");
			vendor.setOrderType(dbHelper.getOderTypes().get(0).getId());
		}
		try {
			return String.valueOf(dbHelper.addOrUpdateVendor((Vendor) entity));
		} catch (SQLException e) {
			String msg = "Error while creating the vendor; " + vendor;
			System.err.println(msg);
			throw new EntityException(msg, ref.getId());
		}
	}

	public void updateEntity(EntityReference ref, Object entity,
			Map<String, Object> params) {
		Vendor vendor = (Vendor) entity;
		DBSupportHelper dbHelper = DBSupportHelper.getInstance();
		if (!vendor.isPurchaseOrderAvailable()) {
			vendor.setPurchaseNumber("");
			vendor.setOrderType(dbHelper.getOderTypes().get(0).getId());
		}
		try {
			DBSupportHelper.getInstance().addOrUpdateVendor(vendor);
		} catch (SQLException e) {
			String msg = "Error while updating the vendor; " + vendor;
			System.err.println(msg);
			throw new EntityException(msg, ref.getId());
		}
	}

	public void deleteEntity(EntityReference ref, Map<String, Object> params) {
		String msg = null;
		try {
			DBSupportHelper.getInstance().deleteVendor(Integer.valueOf(ref.getId()));
		} catch (NumberFormatException e) {
			msg = "Error parsing the vendor id.";
		} catch (SQLException e) {
			msg = "Error while deleting the vendor; ID: " + ref.getId();
		}
		if (msg != null) {
			System.err.println(msg);
			throw new EntityException(msg, ref.getId());
		}
	}

	public String[] getHandledOutputFormats() {
		return new String[] { Formats.HTML, Formats.JSON, Formats.FORM };
	}

	public String[] getHandledInputFormats() {
		return new String[] { Formats.HTML, Formats.JSON, Formats.FORM };
	}

	public boolean entityExists(String id) {
		try {
			return DBSupportHelper.getInstance().getVendor(Integer.valueOf(id)) != null;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
