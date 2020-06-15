package com.sap.masterstipendium.model;
import java.util.UUID;

import javax.persistence.Entity;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "STUDENT")
public class Student {
	
	@Id
	@Column(name = "USERNAME", unique = true)
	private String iuser;
	
	@Column(name = "FIRSTNAME")
	private String fname;
	
	@Column(name = "LASTNAME")
	private String lname;
	
	@Column(name = "COURSE_OF_STUDY")
	private String cofStudy;
	
	@Column(name = "COURSE")
	private String course;
	
	@Column(name = "TRAINER")
	private String trainer;
	
	@Column(name = "FEEDBACK_PRACTICAL_PHASE")
	private String ppFeedback;
	
	@Column(name = "COMMENT_PRACTICAL_PHASE")
	private String cPracticalphase;
	
	@Column(name = "GRADE_POINT_AVERAGE")
	private double gpavg;
	
	@Column(name = "COMMENT_ENGAGEMENT")
	private String cEngagement;
	
	@Column(name = "NOTES")
	private String notes;
	
	public Student() {
		
	}
	
	public Student(String iuser, String fname, String lname, String cofstudy, String course, String trainer, String ppfeedback, String cpracticalphase, double gpavg, String cengagement, String notes) {
		this.iuser = iuser;
		this.fname = fname;
		this.lname = lname;
		this.cofStudy = cofstudy;
		this.course = course;
		this.trainer = trainer;
		this.ppFeedback = ppfeedback;
		this.cPracticalphase = cpracticalphase;
		this.gpavg = gpavg;
		this.cEngagement = cengagement;
		this.notes = notes;
	}
	
}
