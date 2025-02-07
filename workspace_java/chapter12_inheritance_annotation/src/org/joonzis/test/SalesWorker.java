package org.joonzis.test;

public class SalesWorker extends SalaryWorker {
	double salesIncentive; // 판매 인센티브

	public SalesWorker() {}

	public SalesWorker(String name, String dept, int salary, double salesIncentive) {
		super(name, dept, salary);
		this.salesIncentive = salesIncentive;
	}

	int salesPay() {
		return (int) (salary * salesIncentive);
	}

	@Override
	int pay() {
		return salary;
	}

	@Override
	void output() {
		super.output();
		System.out.println("판매 인센티브 : " + salesIncentive);
		System.out.println("수당 : " + salesPay() + "만원");
	}

}
