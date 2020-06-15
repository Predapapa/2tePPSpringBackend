package com.sap.masterstipendium.service;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;


import org.springframework.stereotype.Service;

import com.sap.masterstipendium.model.Student;
import com.sap.masterstipendium.repository.StudentRepository;

@Service
public class StudentService {
	
	private StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public void createStudent(final Student student) {
		if (!studentRepository.existsStudentByIuser(student.getIuser())) {
			studentRepository.save(student);
		} else {
			throw new EntityExistsException("Could not save Student entity with username " + student.getIuser() +" . An entity with that usernname already exists.");
		}
	}
	
	public Student getStudentByUsername(String username) {
		return studentRepository.findStudentByIuser(username);
	}
	
	public List<Student> getAll() {
		return studentRepository.getAll();
	}
	
	public List<Student> getAllStudentsFromTrainer(String trainer) {
		return studentRepository.getAllStudentsFromTrainer(trainer);
	}
	
	public List<Student> getAllStudendsFromCofStudy(String cofStudy){
		return studentRepository.getAllStudentsFromCofStudy(cofStudy);
	}
	
	public void deleteStudent(String username) {
		if (studentRepository.existsStudentByIuser(username)) {
			studentRepository.deleteStudentByIuser(username);
		} else {
			throw new EntityNotFoundException("Could not delete Student with username: " + username +" because the Student entity does not exist.");
		}
	}
	
	public Student updateStudent(final Student student) {
		if(studentRepository.existsStudentByIuser(student.getIuser())) {
			studentRepository.save(student);
			return studentRepository.findStudentByIuser(student.getIuser());
		} else {
			throw new EntityNotFoundException("Could not update Student with username " + student.getIuser() +" because the Student entity does not exist.");
		}
	}
	






}
