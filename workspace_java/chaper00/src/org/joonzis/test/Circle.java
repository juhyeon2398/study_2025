package org.joonzis.test;

//Cricle.java 			

//- 필드 : double radius
//- 메소드 : Constructor, calcArea, output
//CricleMain.java			
//Circle 3개 생성 (반지름 입력 받아서 처리), 가장 크기가 큰 Circle 출력
//★
//calcArea => Math.PI * Math.pow(radius, 2)
//output => 반지름, 크기 출력

public class Circle {
	private double radius;

	public Circle() {
	}

	public Circle(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	private double calcArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	public void output() {
		System.out.println("반지름 : " + radius);
		System.out.println("크기 : " + calcArea());
	}
}
