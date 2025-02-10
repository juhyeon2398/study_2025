package org.joonzis.test;

public class PartTimeWorker extends Employee {
	private int workTime, payPerHour;

	public int getPayPerHour() {
		return payPerHour;
	}

	public void setPayPerHour(int payPerHour) {
		this.payPerHour = payPerHour;
	}

	public int getWorkTime() {
		return workTime;
	}

	public void setWorkTime(int workTime) {
		this.workTime = workTime;
	}

	public PartTimeWorker() {
	}

	public PartTimeWorker(String name, String dept, int workTime, int payPerHour) {
		super(name, dept);
		setWorkTime(workTime);
		setPayPerHour(payPerHour);
	}

	@Override
	public int pay() {
		return workTime * payPerHour;
	}

	@Override
	public void output() {
		super.output();
		System.out.println("시급 : " + getPayPerHour());
		System.out.println("일한시간 : " + getWorkTime());
	}

}
