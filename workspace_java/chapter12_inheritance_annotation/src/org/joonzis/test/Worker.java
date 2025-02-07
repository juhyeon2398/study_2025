package org.joonzis.test;

public class Worker extends Human {
	String job;

	public Worker() {}
	public Worker(String job, String name, int age) {
		super(name, age);
		this.job = job;
	}

	@Override
	void output() {
		super.output();
		System.out.println("직업 : " + job);
	}
}
