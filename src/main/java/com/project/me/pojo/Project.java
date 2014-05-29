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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Entity
@Table(name = "project")
@Repository
public class Project   {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PROJECT_ID", unique=true, nullable=false)
	private Long projectID;
	
	@Column(name="PROJECT_NAME",  nullable=false)
	private String projectName;
//	@Column(name="PROJECT_ADMIN" , nullable=false)
//	private User userAdmin;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "projects" )
	private Set<User> projectMembers = new HashSet<User>();
	@Column(name="PROJECT_START_DATE",  nullable=false)
	private String startDate;
	@Column(name="PROJECT_ENDDATE",  nullable=false)
	private String endDate;
	@Column(name="PROJECT_TYPE",  nullable=false)
	private String type;
	public Long getProjectID() {
		return projectID;
	}
	public void setProjectID(Long projectID) {
		this.projectID = projectID;
	}
	@OneToMany(fetch=FetchType.EAGER, mappedBy="project", cascade=CascadeType.ALL)
	private List<Phase> phases = new ArrayList<Phase>();
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public List<Phase> getPhases() {
		return phases;
	}
	public void setPhases(List<Phase> phases) {
		this.phases = phases;
	}
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Set<User> getProjectMembers() {
		return projectMembers;
	}
	public void setProjectMembers(Set<User> projectMembers) {
		this.projectMembers = projectMembers;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
	
	
}
