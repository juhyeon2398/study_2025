package org.joonzis.test;

//Student.java			
//필드 - String name, String dept, Grade grade
//메소드 - Constructor, output

public class Student {
	String name, dept;
	Grade grade;

	public Student() {
	}

	public Student(String name, String dept, Grade grade) {
		super();
		this.name = name;
		this.dept = dept;
		this.grade = grade;
	}

	void output() {
		System.out.println("이름 : " + name);
		System.out.println("학과 : " + dept);
		System.out.println("학점 : " + grade.getGrade());
		System.out.println("평균 : " + grade.getAverage());
	}

}
