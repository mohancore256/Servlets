 package com.sample.daoImpl;

import java.sql.ResultSet;

import com.sample.dao.AbstractDAO;
import com.sample.dao.LoginDAO;
import com.sample.model.User;

public class LoginDAOImpl  extends AbstractDAO implements LoginDAO {

	@Override
	public Boolean verifyUser(User user) {
		if(user != null) { 
			try {
				Boolean isCredentialsValid  =isUserValid(user); 
				if(isCredentialsValid) {
					return Boolean.TRUE;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(connection);
			}			
		}
		return Boolean.FALSE;
	}
	
	public Boolean isUserValid(User user) {	
		String QUERY = "select studID,firstName,lastName,Email_Id,userName,user_password from user_info where username = '";
	try {
		QUERY = QUERY + user.getUserName()+"'";
		ResultSet resultSet = excuteQuery(QUERY);
		User userObj =  getModelFromResultSet(resultSet);
		if(userObj != null && user.getPassword().equals(userObj.getPassword())) {
			return Boolean.TRUE;
		}		
	} catch (Exception e) {
      e.printStackTrace();
	}finally {
		close(connection);
	}
		return Boolean.FALSE;
	}
	
	
	public User getModelFromResultSet(ResultSet resultSet) {
		User user = null;
		try {
			if(resultSet != null) {
				while(resultSet.next()) {
					user = new User();
					user.setStudID(resultSet.getInt(1));
					user.setFirstName(resultSet.getString(2));					
					user.setLastName(resultSet.getString(3));
					user.setEmail_Id(resultSet.getString(4));
					user.setUserName(resultSet.getString(5));
					user.setPassword(resultSet.getString(6));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
