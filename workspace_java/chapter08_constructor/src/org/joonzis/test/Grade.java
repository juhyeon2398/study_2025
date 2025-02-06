package org.joonzis.test;

//Q3.
//Grade.java				
//필드 - int kor, int eng, int mat, double average, char grade
//메소드 - Constructor, getAverage : 평균을 리턴, getGrade : 학점을 리턴
//** 학점 : 90이상 A, 80이상 B, 70이상 C, 60이상 D, 60미만 F 

public class Grade {
	int kor, eng, mat;
	double average;
	char grade;

	public Grade() {
	}

	public Grade(int kor, int eng, int mat) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	double getAverage() {
		return average = (kor + eng + mat) / 3.0;
	}

	char getGrade() {
		if (getAverage() >= 90) {
			grade = 'A';
		} else if (getAverage() >= 80) {
			grade = 'B';
		} else if (getAverage() >= 70) {
			grade = 'C';
		} else if (getAverage() >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}
		return grade;
	}
}
