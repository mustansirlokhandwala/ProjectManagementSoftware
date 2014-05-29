package com.project.me.pojo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Repository;

@Entity
@Table(name="useraccount" )
@Repository
public class UserAccount {
	
	@GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="user"))
	@Id
	@GeneratedValue(generator="generator")
	@Column(name="USERACCOUNT_ID", unique=true, nullable=false)
	private long id;
	@Column(name="USERNAME", unique=true, nullable=false)
	private String username;
	@Column(name="PASSWORD", unique=true, nullable=false)
	private String password;
	@Column(name = "ROLE" , nullable=false)
	private String role;
	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;
	
	
	
	@OneToMany(fetch=FetchType.EAGER , mappedBy="fromUser" , cascade=CascadeType.ALL)
	private List<AddRequest> outrequest = new ArrayList<AddRequest>();
	
	
	
	
	
	
	
	
	public List<AddRequest> getOutrequest() {
		return outrequest;
	}
	public void setOutrequest(List<AddRequest> outrequest) {
		this.outrequest = outrequest;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
