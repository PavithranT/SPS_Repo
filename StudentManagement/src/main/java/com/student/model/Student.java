package com.student.model;

public class Student {
	private int id;
	private String fullName;
	private int age;
	private String gender;
	private String class1;
	private String section;

	// aggregation method applied
	private Mark mark;

	public Student(String fullName, int age, String gender, String class1, String section) {

		this.fullName = fullName;
		this.age = age;
		this.gender = gender;
		this.class1 = class1;
		this.section = section;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getClass1() {
		return class1;
	}

	public void setClass1(String class1) {
		this.class1 = class1;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Mark getMark() {
		return mark;
	}

	public void setMark(Mark mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + fullName + ", age=" + age + ", gender=" + gender + ", class1=" + class1
				+ ", section=" + section + ", mark=" + mark + "]";
	}

}
