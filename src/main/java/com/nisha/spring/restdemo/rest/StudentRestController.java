package com.nisha.spring.restdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nisha.spring.restdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	// get mapping for the request /students
	@GetMapping("/students")
	public List<Student> getStudents() {
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("Nisha", "Garg"));
		studentList.add(new Student("Poorima", "Patel"));
		studentList.add(new Student("Mario", "Rossi"));
		studentList.add(new Student("Mary", "Smith"));
		return studentList;
	}
}
