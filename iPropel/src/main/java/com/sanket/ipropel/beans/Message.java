package com.sanket.ipropel.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MESSAGE")
public class Message {
	
	@Id
	@GeneratedValue
	@Column(name = "MESSAGEID")
	private int messageId;
	
	@Column(name = "MESSAGE_SENDER")
	private String messageSender;
	
	@Column(name = "MESSAGE_RECIPIENT")
	private String messageRecipient;
	
	@Column(name = "MESSAGE_RECEIVED_TIME")
	private Date messageReceivedTime;
	
	@Column(name = "MESSAGE_CONTENT")
	private String receivedMessage;

	/**
	 * @return the messageId
	 */
	public int getMessageId() {
		return messageId;
	}

	/**
	 * @param messageId the messageId to set
	 */
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	/**
	 * @return the messageSender
	 */
	public String getMessageSender() {
		return messageSender;
	}

	/**
	 * @param messageSender the messageSender to set
	 */
	public void setMessageSender(String messageSender) {
		this.messageSender = messageSender;
	}

	/**
	 * @return the messageRecipient
	 */
	public String getMessageRecipient() {
		return messageRecipient;
	}

	/**
	 * @param messageRecipient the messageRecipient to set
	 */
	public void setMessageRecipient(String messageRecipient) {
		this.messageRecipient = messageRecipient;
	}

	/**
	 * @return the messageReceivedTime
	 */
	public Date getMessageReceivedTime() {
		return messageReceivedTime;
	}

	/**
	 * @param messageReceivedTime the messageReceivedTime to set
	 */
	public void setMessageReceivedTime(Date messageReceivedTime) {
		this.messageReceivedTime = messageReceivedTime;
	}

	/**
	 * @return the receivedMessage
	 */
	public String getReceivedMessage() {
		return receivedMessage;
	}

	/**
	 * @param receivedMessage the receivedMessage to set
	 */
	public void setReceivedMessage(String receivedMessage) {
		this.receivedMessage = receivedMessage;
	}

	/**
	 * 
	 */
	public Message() {
	}

	/**
	 * @param messageSender
	 * @param messageRecipient
	 * @param messageReceivedTime
	 * @param receivedMessage
	 */
	public Message(String messageSender, String messageRecipient, Date messageReceivedTime, String receivedMessage) {
		this.messageSender = messageSender;
		this.messageRecipient = messageRecipient;
		this.messageReceivedTime = messageReceivedTime;
		this.receivedMessage = receivedMessage;
	}
	
	
	

}
