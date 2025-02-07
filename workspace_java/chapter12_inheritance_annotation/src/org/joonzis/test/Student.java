package org.joonzis.test;

public class Student extends Human {
	String school;

	public Student() {
	}

	public Student(String school, String name, int age) {
		super(name, age);
		this.school = school;
	}

	@Override
	void output() {
		super.output();
		System.out.println("학교 : " + school);
	}
}
