package org.test;

import java.util.Scanner;

public class Student {
//	Q5. 스캐너로 학생의 정보를 입력 받아 계산 후 출력하는 프로그램 구현
	Scanner sc = new Scanner(System.in);
	
	private String name;
	private int kor, eng, mat;
	private double avg;
	private boolean isPass;
	public Student() {
		
	}
	
	
	public Student(String name) {
		this.name = name;
	}

	void input() {
		System.out.print("국어 점수 >>> ");
		this.kor = sc.nextInt();
		System.out.print("수학 점수 >>> ");
		this.mat = sc.nextInt();
		System.out.print("영어 점수 >>> ");
		this.eng = sc.nextInt();
		
		this.avg = (kor + eng + mat) / 3.0;
		this.isPass = avg >= 80;  
	}
	
	double getAvg() {
		return avg;
	}
	
	String getPass() {
		return isPass ? "합격" : "불합격" ;
	}
	
	void output() {
		System.out.println("이름 :" + name);
		System.out.println("평균 :" + getAvg());
		System.out.println("합격여부 :" + getPass());
	}
	
	
}
