package com.nisha.spring.restdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nisha.spring.restdemo.entity.Student;
import com.nisha.spring.restdemo.entity.StudentErrorResponse;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	// define PostConstruct to load the students data.. only once!
	List<Student> studentList;
	@PostConstruct
	public void loadData() {
		studentList = new ArrayList<>();
		studentList.add(new Student("Nisha", "Garg"));
		studentList.add(new Student("Poorima", "Patel"));
		studentList.add(new Student("Mario", "Rossi"));
		studentList.add(new Student("Mary", "Smith"));
	}
	// get mapping for the request /students
	@GetMapping("/students")
	public List<Student> getStudents() {
		return studentList;
	}
	
	// define endpoint for "student/{studentId}" - return student at index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		// just index into the list .... keep it simple for now
		if(studentId >= studentList.size() || studentId < 0 ) {
			throw new StudentNotFoundException("Student id not found: " + studentId);
		}
		return studentList.get(studentId);
	}

}
