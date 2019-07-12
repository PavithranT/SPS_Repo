package com.student.query;

public interface QueryConstants {
	String STUDENTS = "select class as class1, Student.* from Student ;";
	String CREATESTUDENT = "INSERT INTO Student(fullname,age,gender,class,section) VALUES (?,?,?,?,?)";
	String INACTIVESTUDENTS = "select class as class1, Student.* from Student where isDeleted=true;";
	String ACTIVESTUDENTS = "select class as class1, Student.* from Student where isDeleted=false;";
	String UPDATESTUDENT = "UPDATE Student SET fullname=?,age=?,gender=?,class =?,section=? WHERE id = ?;";
	String STUDENT = "select class as class1, Student.* from Student where id = ?;";
	String DELETESTUDENT = "UPDATE Student SET isdeleted=true where id=?;";
	String INSERTMARK = "insert into Mark (lang1,lang2,math,science,social,studentId) values(?,?,?,?,?,?);";
	String UPDATEMARK = "UPDATE Mark SET lang1 = ?, lang2 = ? , math = ?, science = ? , social=? WHERE studentid = ?;";
	String MARKBYID = "select * from Mark where studentid=?;";
}