package com.project.me.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name="addrequest")
public class AddRequest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="REQUEST_ID", unique=true, nullable=false )
	private long id;
	
	@Column(name="TO_USER", nullable=false )
	private String toUser;
	@ManyToOne(fetch = FetchType.EAGER , cascade=CascadeType.ALL)
	@JoinColumn(name="FROM_USER" , nullable=false)
	private UserAccount fromUser;
	@Column(name="REQUEST_DATE" , nullable = false)
	private String requesteddate;
	public String getRequesteddate() {
		return requesteddate;
	}
	public void setRequesteddate(String requesteddate) {
		this.requesteddate = requesteddate;
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
	public UserAccount getFromUser() {
		return fromUser;
	}
	public void setFromUser(UserAccount fromUser) {
		this.fromUser = fromUser;
	}
	

	
	
}
