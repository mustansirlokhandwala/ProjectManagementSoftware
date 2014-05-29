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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Entity
@Table(name="user")
@Repository

public class User   {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID", unique=true, nullable=false)
	private long userID;	
	@Column(name="USER_FNAME",  nullable=false, length=50)
	private String firstName;
	@Column(name="USER_LNAME",  nullable=false, length=50)
	private String lastName;
	@Column(name="USER_TITLE",  nullable=false, length=50)
	private String title;
	@Column(name="USER_COMPANY",  nullable=false, length=50)
	private String Company;
	@OneToOne(fetch=FetchType.LAZY, mappedBy="user", cascade=CascadeType.ALL)
	private Address address;
	@Column(name="USER_PHONE",  nullable=false, length=50)
	private long phoneList ;
	@Column(name="USER_EMAIL",  nullable=false, length=50)
	private String email;
	
	@OneToOne(fetch=FetchType.EAGER, mappedBy="user", cascade=CascadeType.ALL)
	private UserAccount userAccount;
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name = "user_projects",  joinColumns = { 
			@JoinColumn(name = "USER_ID") }, 
			inverseJoinColumns = { @JoinColumn(name = "PROJECT_ID") })
	private List<Project> projects = new ArrayList<Project>();
	
	
	@ManyToMany(fetch = FetchType.EAGER ,cascade=CascadeType.ALL)
	@JoinTable(name = "user_collegues" ,joinColumns = {
			@JoinColumn(name ="USER_ID")},
			inverseJoinColumns={@JoinColumn(name ="TEAMMATE_ID") })
	private Set<User> colleagues  = new HashSet<User>();
	
	
	@ManyToMany(mappedBy="colleagues" , fetch=FetchType.EAGER)
    private Set<User> teammates = new HashSet<User>();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Set<User> getColleagues() {
		return colleagues;
	}
	public void setColleagues(Set<User> colleagues) {
		this.colleagues = colleagues;
	}
	public Set<User> getTeammates() {
		return teammates;
	}
	public void setTeammates(Set<User> teammates) {
		this.teammates = teammates;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public Address getAddressList() {
		return address;
	}
	public void setAddressList(Address addressList) {
		this.address = addressList;
	}
	public long getPhoneList() {
		return phoneList;
	}
	public void setPhoneList(long phoneList) {
		this.phoneList = phoneList;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserAccount getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
			
	
	

}
