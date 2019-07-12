package com.student.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.student.model.Mark;
import com.student.query.QueryConstants;

@Repository
public class MarkRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	RowMapper<Mark> mapper = new BeanPropertyRowMapper<Mark>(Mark.class);

	public List<Mark> getAllMark() {
		return jdbcTemplate.query("select * from Mark", mapper);
	}

	public Mark getMarkByStudentID(int id) {
		Mark mark = null;
		try {
			mark = jdbcTemplate.queryForObject(QueryConstants.MARKBYID, new Object[] { id }, mapper);
		} catch (Exception e) {
			return null;
		}
		return mark;
	}

	public Mark enterMarkByStudentID(int id, Mark mark) {
		// TODO Auto-generated method stub
		StudentRepository repository = new StudentRepository();
		// checks whether Student data is in table or not
		if (repository.getStudentByID(id) != null)
			return null;
		// if there is no mark of the student, it add the mark, else it update the
		// existing mark
		if (getMarkByStudentID(id) != null) {
			// "update is executed"
			jdbcTemplate.update(QueryConstants.UPDATEMARK, mark.getLang1(), mark.getLang2(), mark.getMath(),
					mark.getScience(), mark.getSocial(), id);
		} else {
			// "insert is executed"
			jdbcTemplate.update(QueryConstants.INSERTMARK, mark.getLang1(), mark.getLang2(), mark.getMath(),
					mark.getScience(), mark.getSocial(), id);
		}
		return mark;
	}

}
