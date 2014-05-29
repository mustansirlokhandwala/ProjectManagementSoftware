package com.project.me.pojo;

import java.io.File;

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
@Table(name = "deliverable")
public class Deliverable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DELIVERABLE_ID", unique=true, nullable=false )
	private long did;
	@Column(name="DELIVERABLE_NAME", nullable=false )
	private String deliverableName;
	@Column(name="DELIVERABLE_SUBMISSION")
	private File submission;
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="PHASE_ID", nullable=false )
	private Phase phase;
	public long getDid() {
		return did;
	}
	public void setDid(long did) {
		this.did = did;
	}
	public String getDeliverableName() {
		return deliverableName;
	}
	public void setDeliverableName(String deliverableName) {
		this.deliverableName = deliverableName;
	}
	public File getSubmission() {
		return submission;
	}
	public void setSubmission(File submission) {
		this.submission = submission;
	}
	public Phase getPhase() {
		return phase;
	}
	public void setPhase(Phase phase) {
		this.phase = phase;
	}
	
	
	
	
	
}
