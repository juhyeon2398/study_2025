package org.joonzis.test;

public class PartTimeWorker extends Employee {
	int workTime, payPerHour;

	public PartTimeWorker() {
	}

	public PartTimeWorker(String name, String dept, int workTime, int payPerHour) {
		super(name, dept);
		this.workTime = workTime;
		this.payPerHour = payPerHour;
	}
	
	@Override
	int pay() {
		return workTime * payPerHour;
	}

	@Override
	void output() {
		super.output();
		System.out.println("알바 시간 : " + workTime + "시간");
		System.out.println("시급 : " + payPerHour + "원");
		System.out.println("하루 일당 : " + pay() + "원");
	}
}
