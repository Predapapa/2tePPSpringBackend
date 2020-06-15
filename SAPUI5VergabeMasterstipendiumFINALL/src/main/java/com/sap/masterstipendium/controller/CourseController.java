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

import com.sap.masterstipendium.model.Course;
import com.sap.masterstipendium.service.CourseService;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {
	
	private CourseService courseService;
	
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
		courseService.createCourse(new Course("WI 2019 RV", "WI", "2019", "RV"));
		courseService.createCourse(new Course("WI 2019 KA SE", "WI", "2019", "KA SE"));
		courseService.createCourse(new Course("WI 2019 KA SC", "WI", "2019", "KA SC"));
	}
}
