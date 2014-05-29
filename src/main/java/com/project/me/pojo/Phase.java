package com.project.me.pojo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;
@Repository
@Entity
@Table(name ="phase")
public class Phase {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PHASE_ID", unique=true, nullable=false)
	private long phaseId;
	@Column(name="PHASE_NAME",  nullable=false)
	private String phaseName;
	@Column(name="PHASE_START_DATE", nullable=false)
	private Date startDate;
	@Column(name="PHASE_END_DATE",  nullable=false)
	private Date endDate;	
	@Column(name="PHASE_STATUS" , nullable = false)
	private boolean phaseStatus = false;
	public boolean isPhaseStatus() {
		return phaseStatus;
	}
	public void setPhaseStatus(boolean phaseStatus) {
		this.phaseStatus = phaseStatus;
	}
	@OneToMany(fetch=FetchType.EAGER, mappedBy="phase", cascade=CascadeType.ALL)
	private List<Deliverable> deverableList;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="PROJECT_ID", nullable=false )
	private Project project;
	public long getPhaseId() {
		return phaseId;
	}
	public void setPhaseId(long phaseId) {
		this.phaseId = phaseId;
	}
	public String getPhaseName() {
		return phaseName;
	}
	public void setPhaseName(String phaseName) {
		this.phaseName = phaseName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public List<Deliverable> getDeverableList() {
		return deverableList;
	}
	public void setDeverableList(List<Deliverable> deverableList) {
		this.deverableList = deverableList;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	
	
	
}
