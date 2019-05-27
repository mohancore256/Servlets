/**
 * 
 */
package com.sample.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.model.User;
import com.sample.service.RegisterService;
import com.sample.serviceImpl.RegisterServiceImpl;

/**
 * @author mkase
 *
 */
public class RegistrationServletController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4268333801416001798L;
	private RegisterService registerService;
	
	public RegistrationServletController() {
		super();
		registerService = new RegisterServiceImpl();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Boolean isRegisterNewUser = Boolean.FALSE;
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email_Id = request.getParameter("Email_Id");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail_Id(email_Id);
        user.setUserName(userName);								
		user.setPassword(password);
        
        isRegisterNewUser = registerService.registerNewUser(user);
        
        if(isRegisterNewUser) {
        	response.sendRedirect("jsp/success.jsp");
        }
        else {
        	//-TODO need to change it
        	response.sendRedirect("jsp/failurepage.jsp");
        }
      //super.doGet(request, response);
	}

}
