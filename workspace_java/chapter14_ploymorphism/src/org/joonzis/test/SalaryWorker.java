package org.joonzis.test;

public class SalaryWorker extends Employee {
	private int salary;

	public SalaryWorker() {
	}

	public SalaryWorker(String name, String dept, int salary) {
		super(name, dept);
		setSalary(salary);
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public int pay() {
		return salary;
	}

	@Override
	public void output() {
		super.output();
		System.out.println("기본급 : " + pay());
	}
}
