package org.joonzis.test;

import java.util.Random;

//Q4. Test04.java
//
//Student 클래스				
//필드 :
//	String no(학번), String name, int[] scores(국,영,수)
//     double average, char grade, 상수 int COURSE_COUNT(과목수)
//메소드 : 
//Student(String no, String name)
//setter{
//	setScores(int kor, int eng, int mat) - 직접 입력
//	setScores(int[] scores) - 랜덤 입력
//	setAverage()
//	setGrade()
//}
//toString() 학번, 성명, 평균, 학점 출력
//equals() 학번이 같으면 같은 학생으로 비교   

class Student {
	private String no; // (학번),
	private String name;
	private int[] scores; // (국,영,수)
	private double average;
	private char grade; // 상수
	public static final int COURSE_COUNT = 3; // (과목수)

	public Student(String no, String name) {
		this.no = no;
		this.name = name;
	}

	void setScores(int kor, int eng, int mat) {
		scores = new int[COURSE_COUNT];
		this.scores[0] = kor;
		this.scores[1] = mat;
		this.scores[2] = eng;
		this.average = setAverage();
		this.grade = setGrade();
	}

	void setScores(int[] scores) { // 랜덤 입력
		this.scores = scores;
		Random random = new Random();
		this.scores[0] = random.nextInt(101);
		this.scores[1] = random.nextInt(101);
		this.scores[2] = random.nextInt(101);
		this.average = setAverage();
		this.grade = setGrade();
	}

	public double setAverage() {
		return (double) (this.scores[0] + this.scores[1] + this.scores[2]) / COURSE_COUNT;
	}

	public char setGrade() {
		if (setAverage() >= 90) {
			return 'A';
		} else if (setAverage() >= 80) {
			return 'B';
		} else if (setAverage() >= 70) {
			return 'C';
		} else if (setAverage() >= 60) {
			return 'D';
		} else {
			return 'F';
		}
	}

	@Override
	public String toString() {
		return "학번 : " + no + "\n이름 : " + name + "\n국어 : " + this.scores[0] + ", 영어 : " + this.scores[1] + ", 수학 : "
				+ this.scores[2] + "\n평균 : " + average + "\n등급 : " + grade;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Student) {
			Student other = (Student) obj;
			return (this.no).equals(other.no);
		} else {
			return false;
		}
	}
}

public class Test04 {
	public static void main(String[] args) {
		Student stu = new Student("1234", "홍길동");
		Student stu2 = new Student("1234", "김씨");

		stu.setScores(90, 60, 80);
		System.out.println(stu.toString());

		System.out.println("=====================================================");
		stu2.setScores(new int[3]);
		System.out.println(stu2.toString());

		System.out.println(stu.equals(stu2) ? "학번이 같다! 같은사람" : "학번이 다르다! 다른사람");

	}
}
