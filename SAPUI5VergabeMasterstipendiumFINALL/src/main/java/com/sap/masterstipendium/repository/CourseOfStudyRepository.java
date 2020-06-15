package com.sap.masterstipendium.repository;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sap.masterstipendium.model.CourseOfStudy;

@Repository
public interface CourseOfStudyRepository extends JpaRepository<CourseOfStudy, Integer> {
	
	public CourseOfStudy findCourseOfStudyByAbbreviation(String abbreviation);
	
	@Transactional
	public void deleteCourseOfStudyByAbbreviation(@Param("ABBREVIATION")String abbreviation);
	
}
