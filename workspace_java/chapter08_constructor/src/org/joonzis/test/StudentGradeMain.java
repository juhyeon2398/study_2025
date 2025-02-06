package org.joonzis.test;

public class StudentGradeMain {
	public static void main(String[] args) {
		Grade grade = new Grade(89,28,91);
		Student stu = new Student("홍길동","컴공", grade);
		
		stu.output();
	}
}
