package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {
	private List<Student> students = new ArrayList<>(List.of(
			new Student(1, "Omkar", 79),
			new Student(2, "Kaif", 67),
			new Student(3, "Ali", 45)
			));
	@GetMapping("/students")
	public List<Student> getStudents(){
		return students;
	}
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		students.add(student);
		return student;
	}
	
	@GetMapping("/csrf-token")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
}
