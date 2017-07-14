package com.chatapp.server.service;

import com.chatapp.server.beans.Profile;

public interface ProfileService {
	
	public Profile updateProfile(Profile profile);
	
	public Profile removeFriend(Profile removeFrom , Profile remove);
	
}
