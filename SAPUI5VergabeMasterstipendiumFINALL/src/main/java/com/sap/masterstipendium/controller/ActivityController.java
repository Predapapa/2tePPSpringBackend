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

import com.sap.masterstipendium.model.Activity;
import com.sap.masterstipendium.service.ActivityService;

@RestController
@RequestMapping("/api/v1/activity")
public class ActivityController {
	
	private ActivityService activityService;
	
	public ActivityController(ActivityService activityService) {
		this.activityService = activityService;
		
	}
	
	// Create Activity
	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity createActivity(@RequestBody Activity activity) {
		activityService.createActivity(activity);
		return new ResponseEntity<>(activity, HttpStatus.CREATED);
	}
	
	// Get Activities from one specific Student
	@GetMapping(path = "/get/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Activity>> getActivitiesOfStudent(@PathVariable(name = "username") String username){
		return new ResponseEntity<List<Activity>>(activityService.getActivitesFromStudent(username), HttpStatus.OK);
	}
	
	// Get Activity By Id
	@GetMapping(path ="/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Activity> getActivityById(@PathVariable(name = "id") String id){
		return new ResponseEntity<>(activityService.getActivityById(id), HttpStatus.OK);
	}
	
	// Update Activity
	@PutMapping(path ="/update/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity updateActivity(@RequestBody Activity activity) {
		activityService.updateActivity(activity);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	// Delete Activity
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<List<Activity>> deleteActivity(@PathVariable(name = "id") String id) {
		activityService.deleteActivity(id);
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
	
	
}
