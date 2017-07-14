package com.chatapp.server.service;

import com.chatapp.server.beans.Request;

public interface RequestService {

	public Boolean sendRequest(Request request);

	public Boolean acceptReques(Request request);

}
