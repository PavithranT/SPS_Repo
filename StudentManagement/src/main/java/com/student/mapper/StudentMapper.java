package com.student.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.student.model.Student;

public class StudentMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setId(rs.getInt("id"));
		student.setFullName(rs.getString("fullName"));
		student.setGender(rs.getString("gender"));
		student.setAge(rs.getInt("age"));
		student.setClass1(rs.getString("class"));
		student.setSection(rs.getString("section"));
		return student;
	}

}
