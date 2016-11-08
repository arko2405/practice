package com.chatapp.server.service;

import com.chatapp.server.beans.Message;
import com.chatapp.server.beans.User;

public interface MessageService {
	
	public Boolean storeMessageinQueue(Message message);
	
	public Boolean getMessage(User user);
	
	public Boolean deleteMessage(Message message);

}
