package org.joonzis.test;

//Circle.java				
//필드 - Coordinate center, double radius
//메소드 - Constructor, output

public class Circle {
	Coordinate center;
	double radius;

	public Circle() {
	}

	public Circle(Coordinate center, double radius) {
		super();
		this.center = center;
		this.radius = radius;
	}
	
	double calcArea() {
		return Math.PI*radius*radius;
	}

	void output() {
		center.output();
		System.out.println("원의 반지름 : " + radius);
		System.out.println("원의 넓이 : " + calcArea());
	}
}
