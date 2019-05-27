/**
 * 
 */
package com.sample.daoImpl;

import java.sql.ResultSet;

import com.sample.dao.AbstractDAO;
import com.sample.dao.RegisterDAO;
import com.sample.model.User;

/**
 * @author mkase	
 *
 */
public class RegisterDAOImpl extends AbstractDAO implements RegisterDAO  {
	
	@Override
     public Boolean registerUser(User user) {    	 
		try {
			Boolean isExcistingUser = isUserExisted(user);
			if(!isExcistingUser) {
				String QUERY = "insert into user_info (  firstName, lastName, Email_Id, userName,user_password )values ('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getEmail_Id()+"','"+user.getUserName()+"','"+user.getPassword()+"')";		
				return insert(QUERY);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(connection);
		}
		return Boolean.FALSE; 	 
     }

	@Override
	public Boolean isUserExisted(User user) {
		String QUERY = "select studID,firstName,lastName,Email_Id,userName,user_password from user_info where  userName='";
		try {
			if(user != null) {
				QUERY = QUERY +user.getUserName()+"'";
				ResultSet resultSet = excuteQuery(QUERY);
				User userObj =  getModelFromResultSet(resultSet);
				if(userObj != null) {
					return Boolean.TRUE;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(connection);
		}
		return Boolean.FALSE;
	}

	@Override
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
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
