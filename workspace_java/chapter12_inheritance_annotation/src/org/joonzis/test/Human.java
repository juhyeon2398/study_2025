package org.joonzis.test;

public class Human {
	String name;
	int age;
	
	public Human() {}
	public Human(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	void output() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
}
