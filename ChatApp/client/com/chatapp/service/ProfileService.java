package com.chatapp.service;

import com.chatapp.beans.Profile;

public interface ProfileService {
	
	public Profile updateProfile(Profile profile);
	
	public Profile removeFriend(Profile removeFrom , Profile remove);
	
}
