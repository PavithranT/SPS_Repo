package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Mark;
import com.student.model.Student;
import com.student.repository.MarkRepository;
import com.student.repository.StudentRepository;

@RestController
@RequestMapping(path = "/student")
public class StudentController {
	@Autowired
	StudentRepository studentRepo;
	@Autowired
	MarkRepository markRepo;

	@GetMapping
	public String greeting() {
		return "Welcome to Student Page portal";
	}

	@GetMapping(path = "/students")
	public List<Student> getActiveStudents() {
		return studentRepo.getActiveStudents();
	}

	@GetMapping(path = "/students/all")
	public List<Student> getAllStudents() {
		return studentRepo.getAllStudent();
	}

	@GetMapping(path = "/students/inactive")
	public List<Student> getInActiveStudents() {
		return studentRepo.getInActiveStudents();
	}

	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable("id") int id) {
		return studentRepo.getStudentByID(id);
	}

	@PostMapping("student")
	public Student createStudent(@RequestBody Student student) {
		return studentRepo.addStudent(student);
	}

	@PutMapping("student")
	public Student updateStudent(@RequestBody Student student) {
		return studentRepo.updateStudent(student);
	}

	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable("id") int id) {
		if (studentRepo.getStudentByID(id) == null) {
			return "Invalid ID";
		}
		return studentRepo.deleteStudent(id);
	}

	@GetMapping("/student/{id}/mark")
	public Mark getMarkByID(@PathVariable("id") int id) {
		return markRepo.getMarkByStudentID(id);
	}

	@PostMapping("/student/{id}/mark")
	public Mark enterMarkByStudentID(@PathVariable("id") int id, @RequestBody Mark mark) {
		return markRepo.enterMarkByStudentID(id, mark);
	}

}
