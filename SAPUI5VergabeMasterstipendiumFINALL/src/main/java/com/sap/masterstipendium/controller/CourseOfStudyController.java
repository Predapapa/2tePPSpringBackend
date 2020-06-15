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

import com.sap.masterstipendium.model.CourseOfStudy;
import com.sap.masterstipendium.service.CourseOfStudyService;

@RestController
@RequestMapping("/api/v1/courseOfStudy")
public class CourseOfStudyController {
	
	private CourseOfStudyService courseOfStudyService;
	
	public CourseOfStudyController(CourseOfStudyService courseOfStudyService) {
		this.courseOfStudyService = courseOfStudyService;
		courseOfStudyService.createCourseOfStudy(new CourseOfStudy("WI", "Wirtschaftsinformatik"));
		courseOfStudyService.createCourseOfStudy(new CourseOfStudy("AI", "Angewandte Informatik"));
		courseOfStudyService.createCourseOfStudy(new CourseOfStudy("DM", "Digitale Medien"));
		courseOfStudyService.createCourseOfStudy(new CourseOfStudy("BWL", "Betriebswirtschaftslehre"));
	}
}