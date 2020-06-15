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
@Entity(name = "COURSE_OF_STUDY")
public class CourseOfStudy {
	
	@Id
	@Column(name = "ABBREVIATION")
	private String abbreviation;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	public CourseOfStudy(String abbreviation, String description) {
		this.abbreviation = abbreviation;
		this.description = description;
	}
	
	public CourseOfStudy() {
		
	}
}
