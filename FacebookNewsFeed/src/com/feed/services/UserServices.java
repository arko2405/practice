package com.feed.services;

import com.feed.beans.User;

public interface UserServices {

	public User updateUser(User user);

	public User registerUser(User user);

	public User deleteuser(User user);
	
	public User sendRequest(User sender , User sendTo);
	
	public User acceptRequest(User sender , User receiver);
	
	public User addObserver(User subject , User observer);
	
	public User addToFriendList(User subject , User friendToBeAdded);

}
