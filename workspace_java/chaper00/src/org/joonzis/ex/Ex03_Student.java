package org.joonzis.ex;

public class Ex03_Student {
	String name, dept, score1, score2;
	double average;
	boolean isPass;
	
	public Ex03_Student() {}

	public Ex03_Student(String name, String dept, String score1, String score2) {
		this.name = name;
		this.dept = dept;
		this.score1 = score1;
		this.score2 = score2;
		this.average = getAverage();
		this.isPass = getPass();
	}
	double getAverage() {
		return (Double.parseDouble(score1) + Double.parseDouble(score2)) / 2.0; 
	}
	boolean getPass() {
		return average >= 80 ? true : false;
	}
	void output() {
		System.out.println("이름 : " + name);
		System.out.println("학과 : " + dept);
		System.out.println("평균 점수 : " + average);
		System.out.println("합격유무 : " + (isPass ? "합격" : "불합격"));
	}
	
}
