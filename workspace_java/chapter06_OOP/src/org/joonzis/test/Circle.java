package org.joonzis.test;

//Q1. 
//클래스 Circle
//- 필드 : radius, PI, name
//- 메소드 : info
//클래스 CircleMain
//- 메소드 : main
//값을 대입해서 
//반지름, 이름, 크기(PI*R*R), 둘레(2*PI*R) 값 출력

public class Circle {
	int radius;
	String name;
	
	void info() {
		System.out.println("반지름 >> " + radius);
		System.out.println("이름 >> " + name);
		System.out.println("크기 >> " + Math.PI*radius*radius);
		System.out.println("둘레 >> " + Math.PI*2*radius);
	}
}
