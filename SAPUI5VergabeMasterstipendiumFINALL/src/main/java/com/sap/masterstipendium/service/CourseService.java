package com.sap.masterstipendium.service;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.sap.masterstipendium.model.Course;
import com.sap.masterstipendium.repository.CourseRepository;

@Service
public class CourseService {

	private CourseRepository courseRepository;
	
	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}
	
	public void createCourse(Course course) {
		courseRepository.save(course);
	}
}
