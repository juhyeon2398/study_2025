package org.joonzis.test;

//Day.java				
//- 필드 : String schedule
//- 메소드 : Constructor, getSchedule() : 스케쥴반환,
//	  	setSchedule(String schedule) : 스케쥴 저장, output()

public class Day {
	String schedule;

	public Day() {
	}

	public Day(String schedule) {
		this.schedule = schedule;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
		System.out.println("저장되었습니다.");
	}

	void output() {
		System.out.println("저장된 스케줄 : " + getSchedule());
	}
}
