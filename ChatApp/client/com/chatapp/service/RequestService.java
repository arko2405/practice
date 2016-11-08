package com.chatapp.service;

import com.chatapp.beans.Request;

public interface RequestService {

	public Boolean sendRequest(Request request);

	public Boolean acceptReques(Request request);

}
