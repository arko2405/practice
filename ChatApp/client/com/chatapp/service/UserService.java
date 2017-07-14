package com.chatapp.service;

import com.chatapp.beans.User;

public interface UserService {
	
	public User updateUser(User user);
	
	public User registerUser(User user);
	
	public User deleteuser(User user);
	
	
}
