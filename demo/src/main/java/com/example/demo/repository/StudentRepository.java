package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

//	@Query("select s from Student s where s.age > :age")
	// List<Student> findById(@Param("age") int age);

	// Find student by id
	@Query("select s from Student s where id= :age")
	Optional<Student> findById(@Param("age") long id);

	// Find student by email id
	@Query("select s from Student s where emailid= :emailid")
	Student findByStudentEmailId(@Param("emailid") String emailid);
}