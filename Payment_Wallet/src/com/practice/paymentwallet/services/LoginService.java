package com.practice.paymentwallet.services;

import com.practice.paymentwallet.beans.User;

public interface LoginService {
	
	public Boolean authenticateUser(User user);
	
}
