package com.chatapp.service;

import com.chatapp.beans.ChatRoom;

public interface ChatRoomService {

	public ChatRoom updateChatRoom(ChatRoom chatRoom);

	public ChatRoom createChatRoom(ChatRoom chatRoom);

	public ChatRoom deleteChatRoom(ChatRoom chatRoom);
	
	public ChatRoom addUserToChatRoom(ChatRoom chatRoom);
	

}
