package org.joonzis.test;

//Day.java				
//- 필드 : String schedule
//- 메소드 : Constructor, getSchedule() : 스케쥴반환,
//	  	setSchedule(String schedule) : 스케쥴 저장, output()

public class Day {
	private String schedule;

	public Day() {}
	public Day(String schedule) {
		setSchedule(schedule);
	}

	// 스케쥴반환
	public String getSchedule() {
		return schedule;
	}

	//스케쥴 저장
	public void setSchedule(String schedule) {
		this.schedule = schedule;
		System.out.println("================================================================");
		System.out.println("+++ 저장되었습니다 +++");
	}

	public void output() {
	}
}
