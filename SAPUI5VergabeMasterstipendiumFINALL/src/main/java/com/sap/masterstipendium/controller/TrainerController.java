package com.sap.masterstipendium.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sap.masterstipendium.model.Trainer;
import com.sap.masterstipendium.service.TrainerService;

@RestController
@RequestMapping("/api/v1/trainer")
public class TrainerController {
	
	private TrainerService trainerService;
	
	public TrainerController(TrainerService trainerService) {
		this.trainerService = trainerService;
		trainerService.createTrainer(new Trainer("D458025", "Jürgen", "Traugott"));
		trainerService.createTrainer(new Trainer("D458026", "Niklas", "Busch"));
		trainerService.createTrainer(new Trainer("D458027", "Robert", "Theissen"));
	}
	
	// Create Trainer
	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity createTrainer(@RequestBody Trainer trainer) {
		trainerService.createTrainer(trainer);
		return new ResponseEntity<>(trainer, HttpStatus.CREATED);
	}
	
	// Get all Trainer
	@GetMapping(path = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Trainer>> getAllTrainer() {
		return new ResponseEntity<List<Trainer>>(trainerService.getAll(), HttpStatus.OK);
	}
	
	// Get Trainer By Id
	@GetMapping(path = "/get/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Trainer> getTrainerById(@PathVariable(name = "username") String username) {
		return new ResponseEntity<Trainer>(trainerService.findTrainer(username), HttpStatus.OK);
	}
	
	// Delete Trainer
	@DeleteMapping(path = "/delete/{username}")
	public ResponseEntity<List<Trainer>> deleteTrainer(@PathVariable(name = "username") String username) {
		trainerService.deleteTrainer(username);
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
}
