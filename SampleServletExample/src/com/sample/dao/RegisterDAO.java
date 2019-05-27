package com.sample.dao;

import java.sql.ResultSet;

import com.sample.model.User;

public interface RegisterDAO {
	public Boolean registerUser(User user);
	public Boolean isUserExisted(User user);
	public User getModelFromResultSet(ResultSet resultSet);
}
