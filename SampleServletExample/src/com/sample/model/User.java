/**
 * 
 */
package com.sample.model;

/**
 * @author mkase
 *
 */
public class User {
	private Integer studID;
	private String firstName;
	private String lastName;
	private String Email_Id;
	private String userName;
	private String password;
	
	public User() {
		super();
	}
	              
	public User(Integer studID, String firstName, String lastName, String email_Id, String userName, String password) {
		super();
		this.studID = studID;
		this.firstName = firstName;
		this.lastName = lastName;
		Email_Id = email_Id;
		this.userName = userName;
		this.password = password;
	}
	
	

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public Integer getStudID() {
		return studID;
	}

	public void setStudID(Integer studID) {
		this.studID = studID;
	}




	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail_Id() {
		return Email_Id;
	}

	public void setEmail_Id(String email_Id) {
		this.Email_Id = email_Id;
	}
	
	
	
}
