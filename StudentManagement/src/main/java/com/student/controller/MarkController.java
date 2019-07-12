package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Mark;
import com.student.model.Student;
import com.student.repository.MarkRepository;

@RestController
@RequestMapping("/mark")
public class MarkController {
	@Autowired
	MarkRepository repo;

	@GetMapping
	public String greeting() {
		return "Welcome to Mark Page portal";
	}

	@GetMapping("/marks")
	public List<Mark> getAllMark() {
		return repo.getAllMark();
	}

	@GetMapping("/mark/{id}")
	public Mark getStudentWithMarkByID(@PathVariable("id") int id) {
		return repo.getMarkByStudentID(id);
	}

}
