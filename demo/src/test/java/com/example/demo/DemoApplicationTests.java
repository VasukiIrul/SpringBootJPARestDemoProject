package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.bean.StudentBean;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest

public class DemoApplicationTests {

	@Autowired
	StudentBean sb = null;

	@MockBean
	private StudentRepository repository;

	@Test
	public void testCreateStudent() {
		Student student = new Student();
		student.setName("Vasuki");
		student.setAge(33);
		student.setEmailid("vasuki.tce@gmail.com");

		when(repository.save(student)).thenReturn(student);
		assertEquals(student, sb.findStudentsByEmailId("vasuki.tce@gmail.com"));

	}

	@Test
	public void testFetchAll() {
		List<Student> student = sb.findStudents();
		assertThat(student).size().isGreaterThan(0);
	}

	@Test
	public void testFethById() {

		Student s = sb.findStudentsById(24).get();
		assertEquals(new Long(24), s.getId());

	}

}
