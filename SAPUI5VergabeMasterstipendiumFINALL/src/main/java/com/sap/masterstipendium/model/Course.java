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
@Entity(name = "COURSE")
public class Course {

	@Id
	@Column(name = "ABBREVIATION")
	private String abbreviation;
	
	@Column(name = "ABBREVIATION_COURSE_OF_STUDY")
	private String abbrcofstudy;
	
	@Column(name = "YEAR")
	private String year;
	
	@Column(name = "ADDITIVE")
	private String additive;

	public Course(String abbreviation, String abbrcofstudy, String year, String additive) {
		this.abbreviation = abbreviation;
		this.abbrcofstudy = abbrcofstudy;
		this.year = year;
		this.additive = additive;
	}
	
	public Course() {
		
	}
}
