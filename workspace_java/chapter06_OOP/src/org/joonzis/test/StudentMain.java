package org.joonzis.test;

//Q4. 
//클래스 Student
//- 필드 :
//String name, String dept, String score1, String score2
//double average
//boolean isPass(합격 유무) : 평균 점수가 80점 이상 true, 80점 미만 false
//- 메소드 : 
//input : name, dept, score1, score2 콘솔입력, 평균 및 패스 유무 확인
//output : name, dept, average, isPass ("합격","불합격")
//
//클래스 StudentMain
//- 메소드 : main


public class StudentMain {
	public static void main(String[] args) {
		Student stu = new Student();
		
		stu.input();
		System.out.println();
		stu.output();
	}
}
