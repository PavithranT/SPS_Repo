package com.student.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.student.model.Mark;

public class MarkMapper implements RowMapper<Mark> {
	@Override
	public Mark mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Mark mark = new Mark();
		mark.setLang1(rs.getInt(2));
		mark.setLang2(rs.getInt(3));
		mark.setMath(rs.getInt(4));
		mark.setScience(rs.getInt(5));
		mark.setSocial(rs.getInt(6));
		return mark;
	}
}
