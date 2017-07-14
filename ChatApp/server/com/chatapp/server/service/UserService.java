package com.chatapp.server.service;

import com.chatapp.server.beans.User;

public interface UserService {
	
	public User updateUser(User user);
	
	public User registerUser(User user);
	
	public User deleteuser(User user);
	
	
}
