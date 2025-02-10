package org.joonzis.test;

public class SalesWorker extends SalaryWorker {
	private int salesVolume;
	private double salesIncentive;

	public int getSalesVolume() {
		return salesVolume;
	}

	public void setSalesVolume(int salesVolume) {
		this.salesVolume = salesVolume;
		if (salesVolume >= 1000) {
			setSalesIncentive(0.1);
		} else if (salesVolume >= 500) {
			setSalesIncentive(0.05);
		} else {
			setSalesIncentive(0.01);
		}
	}

	public double getSalesIncentive() {
		return salesIncentive;
	}

	public void setSalesIncentive(double salesIncentive) {
		this.salesIncentive = salesIncentive;
	}

	public SalesWorker() {
	}

	public SalesWorker(String name, String dept, int salesVolume, int salary) {
		super(name, dept, salary);
		setSalesVolume(salesVolume);
	}

	private int salesPay() {
		return (int) (getSalary() * getSalesIncentive());
	}

	@Override
	public int pay() {
		return (getSalary() + salesPay());
	}

	@Override
	public void output() {
		super.output();
		System.out.println("판매량 : " + getSalesVolume());
		System.out.println("인센티브 : " + getSalesIncentive());
	}
}
