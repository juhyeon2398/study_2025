package org.joonzis.test;

//Q1. Test01.java 상속 관계로 구현하시오.
//
//Student.java				- 필드 : String school
//							- 메소드 : Constructor, output()
//Worker.java					- 필드 : 
//							- 메소드 : Constructor, output()
//→ 부모클래스는 알아서 만들어보자!(Human)

public class Test01 {
	public static void main(String[] args) {
		Student stu = new Student("서울대","홍길동",21);
		stu.output();
		
		Worker worker = new Worker("개발자","김철수",31);
		worker.output();
		
	}
}
