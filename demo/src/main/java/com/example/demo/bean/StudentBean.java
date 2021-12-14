package com.example.demo.bean;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Component
public class StudentBean {

	@Autowired
	StudentRepository repo;

	// create student
	public Student saveStudent(Student s) {
		return repo.save(s);

	}

	// Fetch all student details
	public List<Student> findStudents() {

		return repo.findAll();
	}

	public Student findStudentsByEmailId(String emailid) {

		return repo.findByStudentEmailId(emailid);
	}

	// fetch student by id
	public Optional<Student> findStudentsById(long id) {
		/*
		 * for (Student s : repo.findByAge(age)) { System.out.println(s);
		 * 
		 * } System.out.println("students fetched by age****");
		 */
		return repo.findById(id);
	}
}
