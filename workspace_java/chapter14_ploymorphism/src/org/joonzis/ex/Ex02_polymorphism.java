package org.joonzis.ex;

class Shape {

	// 의미 없는 메소드 (자식들이 사용하기 위해 만듦)
	public double calcArea() {
		return 0;
	}
}

class Rect extends Shape {
	private int width, height;

	public Rect() {
		// TODO Auto-generated constructor stub
	}

	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double calcArea() {
		return width * height;
	}
}

class Triagle extends Shape {
	private int width, height;

	public Triagle() {
	}

	public Triagle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double calcArea() {
		return (width * height) / 2.0;
	}

}

class Circle extends Shape {
	private double radius;

	public Circle() {
	}

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double calcArea() {
//		return Math.PI * radius * radius;
		return Math.PI * Math.pow(radius, 2);
	}
}

public class Ex02_polymorphism {
	public static void main(String[] args) {

		// 길이 3짜리 부모 배열을선언
		// 각각 인덱스에 사각형, 삼각형, 원형 클래스 객체 대입

		Shape[] shape = new Shape[3];
		shape[0] = new Rect(10, 20);
		shape[1] = new Triagle(20, 30);
		shape[2] = new Circle(5);
		for (int i = 0; i < shape.length; i++) {
			System.out.println(shape[i].calcArea());
		}
	}
}
