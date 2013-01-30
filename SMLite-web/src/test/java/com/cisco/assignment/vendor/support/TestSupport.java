package com.cisco.assignment.vendor.support;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cisco.assignment.vendor.helper.HibernateUtil;

public class TestSupport {
	
   public static Session getSession() {
	   SessionFactory sf = HibernateUtil.getSessionFactory();
	   System.out.println(sf);
	   return sf.openSession();
   } 
  
}
