package com.student.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.student.model.Student;
import com.student.query.QueryConstants;

@Repository
public class StudentRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	MarkRepository repo;
	RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);

	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(QueryConstants.CREATESTUDENT, student.getFullName(), student.getAge(), student.getGender(),
				student.getClass1(), student.getSection());
		return student;
	}

	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return this.jdbcTemplate.query(QueryConstants.STUDENTS, rowMapper);
	}

	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		System.err.println("called of update Student");
		// int i = jdbcTemplate.update(QueryConstants.UPDATESTUDENT,
		// student.getFullName(), student.getAge(),
		// student.getGender(), student.getClass1(), student.getSection(),
		// student.getId());
		int i = jdbcTemplate.update(
				"UPDATE Student SET fullname= ? , age= ? , gender = ? ,class = ? , section = ? WHERE id = ? ;",
				student.getFullName(), student.getAge(), student.getGender(), student.getClass1(), student.getSection(),
				student.getId());
		System.err.println(i);
		return getStudentByID(student.getId());
	}

	public Student getStudentByID(int id) {
		// TODO Auto-generated method stub

		Student student = null;
		try {
			student = jdbcTemplate.queryForObject(QueryConstants.STUDENT, new Object[] { id }, rowMapper);
		} catch (Exception e) {
			return null;
		}
		student.setMark(repo.getMarkByStudentID(id));
		return student;
	}

	public String deleteStudent(int id) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(QueryConstants.DELETESTUDENT, id);
		return id + " is been deleted";
	}

	public List<Student> getActiveStudents() {
		return jdbcTemplate.query(QueryConstants.ACTIVESTUDENTS, rowMapper);
	}

	public List<Student> getInActiveStudents() {
		return jdbcTemplate.query(QueryConstants.INACTIVESTUDENTS, rowMapper);
	}
}
