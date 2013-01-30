package com.cisco.assignment.vendor.helper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;

import com.cisco.assignment.vendor.model.OrderType;
import com.cisco.assignment.vendor.model.Vendor;



/**
 * Convenient helper class for DB CRUD operations.<br>
 * <br>
 * <ol>
 * <b><u>DB Details:</u></b>
 * <li>DB Name: vendor</li>
 * <li>Table1: vendor</li>
 * <li>Table2: order_type</li>
 * </ol>
 * 
 * <b><u>Note:</u></b> The DB schema is created using the sql file in this
 * project named "vendor.sql".<br>
 * <br>
 * 
 * 
 */
public class DBSupportHelper {

	/*  Logger reference */
	static Logger LOG = Logger.getLogger(DBSupportHelper.class.getName());
	
	private List<OrderType> listOrderTypes;

	private static DBSupportHelper instance = null;

	public DBSupportHelper() {
	}

	public static DBSupportHelper getInstance() {
		if (instance == null) {
			instance = new DBSupportHelper();
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	public void init() throws ClassNotFoundException, SQLException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from OrderType");
		listOrderTypes = query.list(); 
		session.close();
	}

	

	public Vendor getVendor(int id) throws SQLException {
		Vendor vendor = null;		
		Session session = HibernateUtil.getSessionFactory().openSession();
		vendor = (Vendor) session.get(Vendor.class, id);
		session.close();
		return vendor;		
	}

	@SuppressWarnings("unchecked")
	public List<Vendor> getVendors() throws SQLException {
		List<Vendor> listVendors = new ArrayList<Vendor>(1);
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from Vendor");
		listVendors = query.list();
		session.close();
		return listVendors;
	}

	public int addOrUpdateVendor(Vendor vendor) throws SQLException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(vendor);
		session.getTransaction().commit();
		session.close();
		return vendor == null ? -1 : 1;
	}

	/*public int updateVendor(Vendor vendor) throws SQLException {
		if (conn != null) {
			PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE_VENDOR,
					Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, vendor.getName());
			stmt.setInt(2, vendor.isPurchaseOrderAvailable() ? 1 : 0);
			stmt.setString(3, vendor.getPurchaseNumber());
			stmt.setInt(4, vendor.getOrderType());
			stmt.setInt(5, vendor.getId());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.first()) {
				return rs.getInt(1);
			}
		}
		return -1;
	}
*/
	public void deleteVendor(int id) throws SQLException {
		LOG.info("entry-->"+id);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Vendor v = DBSupportHelper.instance.getVendor(id);
		session.delete(v);
		session.getTransaction().commit();		
		session.close();
		LOG.info("exit-->");
	}

	public List<OrderType> getOderTypes() {
			return listOrderTypes;
	}
}
