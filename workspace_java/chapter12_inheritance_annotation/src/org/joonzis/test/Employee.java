package org.joonzis.test;

public class Employee {
	String name, dept;

	public Employee() {}

	public Employee(String name, String dept) {
		this.name = name;
		this.dept = dept;
	}
	
	int pay() {
		return 0;
	}

	void output() {
		System.out.println("이름 : " + name);
		System.out.println("부서 : " + dept);
	}
}
