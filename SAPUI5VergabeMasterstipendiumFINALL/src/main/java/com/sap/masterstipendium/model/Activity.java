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
@Entity(name = "ACTIVITY")
public class Activity {

	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "USERNAME_OF_STUDENT")
	private String username;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "ROLE_OF_STUDENT")
	private String roleOfStudent;
	
	@Column(name = "TRAINING_YEAR")
	private String trainingYear;

	public Activity(String activityId, String username, String type, String roleOfStudent, String trainingYear) {
		this.id = activityId;
		this.username = username;
		this.type = type;
		this.roleOfStudent = roleOfStudent;
		this.trainingYear = trainingYear;
	}
	
	public Activity() {
		
	}
	
}
