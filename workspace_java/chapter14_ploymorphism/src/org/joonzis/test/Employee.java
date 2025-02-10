package org.joonzis.test;

public class Employee {
	private String name, dept;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Employee() {
	}

	public Employee(String name, String dept) {
		setName(name);
		setDept(dept);
	}

	public int pay() {
		return 0;
	}

	public void output() {
		System.out.println("이름 : " + name);
		System.out.println("부서 : " + dept);
	}
}
