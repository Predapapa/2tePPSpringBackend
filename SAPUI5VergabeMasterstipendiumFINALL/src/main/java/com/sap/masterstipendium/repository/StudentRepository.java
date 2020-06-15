package com.sap.masterstipendium.repository;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sap.masterstipendium.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	@Transactional
	public void deleteStudentByIuser(@Param("USERNAME")String username);
	
	@Query ("SELECT s FROM STUDENT s WHERE s.trainer LIKE:TRAINER")
	List<Student> getAllStudentsFromTrainer(@Param("TRAINER")String trainer);
	
	public boolean existsStudentByIuser(String iuser);
	
	@Query ("SELECT s FROM STUDENT s WHERE s.cofStudy LIKE:COURSE_OF_STUDY")
	List<Student> getAllStudentsFromCofStudy(@Param("COURSE_OF_STUDY")String cofStudy);
	
	@Query ("SELECT s FROM STUDENT s ORDER BY s.lname ASC")
	List<Student> getAll();
	
	public Student findStudentByIuser(String username);
	
	
}
