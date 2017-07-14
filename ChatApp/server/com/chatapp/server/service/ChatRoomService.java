package com.chatapp.server.service;

import com.chatapp.server.beans.ChatRoom;

public interface ChatRoomService {

	public ChatRoom updateChatRoom(ChatRoom chatRoom);

	public ChatRoom createChatRoom(ChatRoom chatRoom);

	public ChatRoom deleteChatRoom(ChatRoom chatRoom);
	
	public ChatRoom addUserToChatRoom(ChatRoom chatRoom);

}
