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

import com.sap.masterstipendium.model.Student;
import com.sap.masterstipendium.service.StudentService;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
	
	private final StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
		studentService.createStudent(new Student("I517458", "Nadine", "Kafumann", "WI", "WI 2019 RV", "Jürgen Traugott", "ppfeedback", "cpracticalphase", 0, "cengagement", ""));
		studentService.createStudent(new Student("I567852", "Uwe", "Baumgartner", "WI", "WI 2019 RV", "Jürgen Traugott", "ppfeedback", "cpracticalphase", 0, "cengagement", ""));
		studentService.createStudent(new Student("I567854", "Bernd", "Mehler", "WI", "WI 2019 RV", "Jürgen Traugott", "ppfeedback", "cpracticalphase", 0, "cengagement", ""));
	}
	
	
	// Create Student
	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity createStudent(@RequestBody Student student) {
		studentService.createStudent(student);
		return new ResponseEntity<>(student, HttpStatus.CREATED);
	}
	
	// Get Student By Username
	@GetMapping(path = "/get/{iuser}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> getStudentByUsername(@PathVariable(name = "iuser") String iuser) {
		return new ResponseEntity<Student>(studentService.getStudentByUsername(iuser), HttpStatus.OK);
	}
	// Get Student By Trainer
	@GetMapping(path = "/get/{trainer}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Student>> getStudentByTrainer(@PathVariable(name = "trainer") String trainer) {
		return new ResponseEntity<List<Student>>(studentService.getAllStudentsFromTrainer(trainer), HttpStatus.OK);
	}
	
	// Get All Students
	@GetMapping(path = "/get/all", produces = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<List<Student>> getAllStudents() {
		return new ResponseEntity<List<Student>>(studentService.getAll(), HttpStatus.OK);
	}
	
	// Update Student
	@PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity updateStudent(@RequestBody Student student) {
		studentService.updateStudent(student);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	// Delete Student
	@DeleteMapping(path = "/delete/{iuser}")
	public ResponseEntity <List<Student>> deleteStudent(@PathVariable(name = "iuser") String iuser) {
		studentService.deleteStudent(iuser);
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
	
}
