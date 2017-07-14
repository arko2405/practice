package com.chatapp.srviceimpl;

import java.util.List;

import com.chatapp.beans.Message;
import com.chatapp.service.MessageService;

public class MessageServiceImpl implements MessageService {


	@Override
	public Boolean storeMessageinQueue(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean relayMessageFromQueueToServer(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getNewMessageFromServer(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

}
