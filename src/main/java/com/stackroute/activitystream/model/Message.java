package com.stackroute.activitystream.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@Entity
public class Message
{
	@Id
	@JsonProperty(value="message_id")
	private int messageId;
	
	@JsonProperty(value="message_type")
	private String messageType;
	
	@JsonProperty(value="message_content")
	private String messageContent;
	
	@JsonProperty(value="sender_email_id")
	private String senderEmailId;
	
	@JsonProperty(value="receiver_email_id")
	private String receiverUserId;
	
	@JsonProperty(value="circle_id")
	private int receiverCircleId;
	
	@JsonProperty(value="message_date")
	private Date messageDate;
	
	@JsonProperty(value="max_size")
	private int maxSize;

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getSenderEmailId() {
		return senderEmailId;
	}

	public void setSenderEmailId(String senderEmailId) {
		this.senderEmailId = senderEmailId;
	}


	public String getReceiverUserId() {
		return receiverUserId;
	}

	public void setReceiverUserId(String receiverUserId) {
		this.receiverUserId = receiverUserId;
	}

	public int getReceiverCircleId() {
		return receiverCircleId;
	}

	public void setReceiverCircleId(int receiverCircleId) {
		this.receiverCircleId = receiverCircleId;
	}

	public Date getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", messageType=" + messageType + ", messageContent=" + messageContent
				+ ", senderEmailId=" + senderEmailId + ", receiverUserId=" + receiverUserId + ", receiverCircleId="
				+ receiverCircleId + ", messageDate=" + messageDate + ", maxSize=" + maxSize + "]";
	}

	
	
	
}
