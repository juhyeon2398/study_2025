package org.joonzis.test;

public class SalaryWorker extends Employee {
	int salary;

	public SalaryWorker() {}
	public SalaryWorker(String name, String dept, int salary) {
		super(name, dept);
		this.salary = salary;
	}
	
	@Override
	int pay() {
		return salary;
	}

	@Override
	void output() {
		super.output();
		System.out.println("기본급 : " + pay() +"만원");
	}

}
