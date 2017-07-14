package com.chatapp.server.beans;

import java.util.List;

public class Message {

	protected Integer messageId;
	protected User sender;
	protected ChatRoom sendTo;
	protected String suject;
	protected List<Attachment> attachments;

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public ChatRoom getSendTo() {
		return sendTo;
	}

	public void setSendTo(ChatRoom sendTo) {
		this.sendTo = sendTo;
	}

	public String getSuject() {
		return suject;
	}

	public void setSuject(String suject) {
		this.suject = suject;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

}
