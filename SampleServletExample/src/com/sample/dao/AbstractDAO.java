/**
 * 
 */
package com.sample.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author mkase
 *
 */
public abstract class AbstractDAO {	
	public Connection connection = null;
	
	public Connection getConnection() {
		try {			
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "mohan");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public ResultSet excuteQuery(String query) {
		ResultSet resultSet = null;
		Statement stmt = null;
		try {
			
			connection = this.getConnection();
			if(connection != null) {
		 stmt = connection.createStatement(); }
			
			if(stmt != null) {
			resultSet = stmt.executeQuery(query);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//close(connection);
		}
			
		return resultSet;
	}
	
	public Boolean insert(String query) {
		try {
			connection = this.getConnection();
			Statement stmt = connection.createStatement(); 
			return !stmt.execute(query);
			// B =	stmt.execute(query);
			 
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(connection);
		}
		
		return Boolean.FALSE;
	}
	
	public void close(Connection connection) {
		try {
			if(connection != null) {
				connection.close();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Boolean update(String query) {
		//Connection connection = null;
		try {
			connection = this.getConnection();
			Statement stmt = connection.createStatement(); 
			return stmt.execute(query);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(connection);
		}
		return Boolean.FALSE;
	}
}
