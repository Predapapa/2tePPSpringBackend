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
@Entity(name = "TRAINER")
public class Trainer {
	
	@Id
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "FIRSTNAME")
	private String fname;
	
	@Column(name = "LASTNAME")
	private String lname;

	public Trainer(String username, String fname, String lname) {
		super();
		this.username = username;
		this.fname = fname;
		this.lname = lname;
	}
	
	public Trainer() {
		
	}
}
