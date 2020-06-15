package com.sap.masterstipendium.service;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.sap.masterstipendium.model.CourseOfStudy;
import com.sap.masterstipendium.repository.CourseOfStudyRepository;

@Service
public class CourseOfStudyService {

	private CourseOfStudyRepository courseOfStudyRepository;
	
	public CourseOfStudyService(CourseOfStudyRepository courseOfStudyRepository) {
		this.courseOfStudyRepository = courseOfStudyRepository;
	}
	
	public void createCourseOfStudy(CourseOfStudy courseOfStudy) {
		courseOfStudyRepository.save(courseOfStudy);
	}
	
	
}