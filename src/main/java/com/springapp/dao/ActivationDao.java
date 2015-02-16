package com.springapp.dao;

import com.springapp.domain.model.Activation;

public interface ActivationDao {

	public String getActivation(String activationId);
	
	public void addActivation(Activation a);
	
	public void deleteActivation(String activationId);
	
}
