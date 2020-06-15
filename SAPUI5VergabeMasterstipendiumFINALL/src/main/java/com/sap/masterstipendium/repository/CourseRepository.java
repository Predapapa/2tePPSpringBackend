package com.sap.masterstipendium.repository;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sap.masterstipendium.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

	@Transactional
	public void deleteCourseByAbbreviation(@Param("ABBREVIATION")String abbreviation);
	
	public Course findCourseByAbbreviation(String abbreviation);
	
}
