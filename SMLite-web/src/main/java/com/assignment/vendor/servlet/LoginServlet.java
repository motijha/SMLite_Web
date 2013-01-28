package com.assignment.vendor.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The servlet that manages the application's all RESTful service providers.
 * 
 * 
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if(req.getParameter("username").equals("welcome") && req.getParameter("password").equals("welcome")) {
			        
			resp.sendRedirect(resp.encodeRedirectURL("vendorOperation.jsp"));

			
		}
	}

}
