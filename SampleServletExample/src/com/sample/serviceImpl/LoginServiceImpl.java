package com.sample.serviceImpl;

import com.sample.dao.LoginDAO;
import com.sample.daoImpl.LoginDAOImpl;
import com.sample.model.User;
import com.sample.service.LoginService;

public class LoginServiceImpl implements LoginService {
	
	private LoginDAO loginDAO;
	
	public LoginServiceImpl() {
		loginDAO = new LoginDAOImpl();	
	}	

	@Override
	public Boolean autthenticateUser(User user) {
		return loginDAO.verifyUser(user);
	}

}
