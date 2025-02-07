package org.joonzis.ex;

import java.util.Scanner;

public class Ex02_Student {
	private String name, dept, score1, score2;
	private double average;
	private boolean isPass;

	public Ex02_Student() {
	}

	public Ex02_Student(String name, String dept) {
		this.name = name;
		this.dept = dept;
	}
	
	public void input(Scanner sc) {
		System.out.println("중간점수 >> ");
		score1 = sc.next();
		System.out.println("기말점수 >> ");
		score2 = sc.next();
		average = getAverage();
		isPass = isPass();
	}

	private double getAverage() {
		return (Double.parseDouble(score1) + Double.parseDouble(score2)) / 2.0;
	}

	private boolean isPass() {
		return getAverage() >= 80; 
	}

	public void output() {
		System.out.println("이름 : " + name);
		System.out.println("학과 : " + dept);
		System.out.println("평균 : " + getAverage());
		System.out.println(isPass() ? "합격" : "불합격");
	}
}
