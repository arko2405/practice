package com.chatapp.service;

import java.util.List;

import com.chatapp.beans.Message;

public interface MessageService {


	public Boolean storeMessageinQueue(Message message);

	public Boolean relayMessageFromQueueToServer(Message message);

	public List<Message> getNewMessageFromServer(Message message);

}
