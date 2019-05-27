/**
 * 
 */
package com.sample.serviceImpl;


import com.sample.dao.RegisterDAO;
import com.sample.daoImpl.RegisterDAOImpl;
import com.sample.model.User;
import com.sample.service.RegisterService;

/**
 * @author mkase
 *
 */
public class RegisterServiceImpl implements RegisterService {

	private RegisterDAO registerDao;
	
	public RegisterServiceImpl() {
		registerDao = new RegisterDAOImpl();
	}
	
	
	
	@Override
	public Boolean registerNewUser(User user) {
		return  registerDao.registerUser(user);
		
	}

}
