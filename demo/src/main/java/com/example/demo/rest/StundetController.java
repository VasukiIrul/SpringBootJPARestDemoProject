package com.example.demo.rest;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.bean.StudentBean;
import com.example.demo.entity.Student;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class StundetController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	StudentBean sb = null;

	// Default Validation
	@PostMapping("/student")
	public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {

		sb.saveStudent(student);
		// return ResponseEntity.ok().body("New Stundet registered successfully");
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	// Fetch by id applied by custom validation
	@GetMapping("/student/{id}")
	public Student get(@PathVariable("id") long id) {
		return sb.findStudentsById(id).orElseThrow(() -> new ResourceNotFoundException("Student couldn't Found " + id));

	}

	//Fetch all students details
	@GetMapping("/student")
	public ResponseEntity<List<Student>> fetchStudents() {
		List<Student> stud = sb.findStudents();
		return ResponseEntity.ok().body(stud);
	}

	

}
