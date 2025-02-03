package org.joonzis.test;

//Q1. 
//클래스 Circle
//- 필드 : radius, PI, name
//- 메소드 : info
//클래스 CircleMain
//- 메소드 : main
//값을 대입해서 
//반지름, 이름, 크기(PI*R*R), 둘레(2*PI*R) 값 출력


public class CircleMain {
	public static void main(String[] args) {
		Circle circle = new Circle();
		circle.name = "홍길동";
		circle.radius = 5;
		
		circle.info();
	}
}
