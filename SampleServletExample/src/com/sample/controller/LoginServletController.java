/**
 * 
 */
package com.sample.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.model.User;
import com.sample.service.LoginService;
import com.sample.serviceImpl.LoginServiceImpl;

/**
 * @author mkase
 *
 */
public class LoginServletController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1278560186455165317L;

	private LoginService loginService;	
	
	public LoginServletController() {
		super();
		loginService = new LoginServiceImpl();	
	}



	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Boolean isAuthenticated = Boolean.FALSE;
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		User user = new User();	
		user.setUserName(userName);								
		user.setPassword(password);
		
		isAuthenticated = loginService.autthenticateUser(user);
		
		if(isAuthenticated) {
			response.sendRedirect("jsp/success.jsp");
		}else {
			response.sendRedirect("jsp/register.jsp");
		}
	}
}
