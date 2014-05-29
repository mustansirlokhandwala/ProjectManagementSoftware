package com.project.me.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;


@Entity
@Table(name="message")
@Repository
public class Message {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MESSAGE_ID", unique=true, nullable=false)
	private long id;
	@Column(name="TO_USER", nullable=false)
	private String toUser;
	@Column(name="To_USERACCOUNT" ,nullable = false)
	private String toUserAccount;
	@Column(name="FROM_USER",  nullable=false)
	private String fromUser;
	@Column(name="FROM_USERACCOUNT",nullable=false)
	private String fromUserAccount;
	public String getToUserAccount() {
		return toUserAccount;
	}
	public void setToUserAccount(String toUserAccount) {
		this.toUserAccount = toUserAccount;
	}
	public String getFromUserAccount() {
		return fromUserAccount;
	}
	public void setFromUserAccount(String fromUserAccount) {
		this.fromUserAccount = fromUserAccount;
	}
	@Column(name="MESSAGE_VALUE", nullable=false)
	private String message;
	@Column(name="MESSAGE_DATE",  nullable=false)
	private String messageDate;
	@Column(name="MESSAGE_STATUS",nullable=false)
	private boolean status = false;
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getToUser() {
		return toUser;
	}
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	public String getFromUser() {
		return fromUser;
	}
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessageDate() {
		return messageDate;
	}
	public void setMessageDate(String messageDate) {
		this.messageDate = messageDate;
	}
	
	
	
	

}
