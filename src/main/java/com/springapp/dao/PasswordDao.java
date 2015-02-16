package com.springapp.dao;

import com.springapp.domain.model.Password;

public interface PasswordDao {

	public String getPassword(String userId);
	
	public void setPassword(Password p);
	
}
