package org.joonzis.ex;

public class Ex04_Circle {
	int x, y; // 좌표
	double radius; // 반지름

	// int x, y : 좌표
	// double radius : 반지름
	//
	// 메소드
	// 생성자() : 좌표 0,0 radius 값 1로 고정
	// 생성자(radius) : 좌표 0,0
	// 풀생성자
	// calcArea() : 원의 크기 리턴 ( PI * r * r)
	// calcCircum() : 원의 둘레 리턴 (2 * PI * r)
	// output() : 원의 중심 좌표, 반지름, 크기, 둘레 출력
	//
	// *** PI 구하기 -> Math.PI

	// 생성자()
	public Ex04_Circle() {
		x = y = 0;
		radius = 1;
	}

	// 생성자(매개변수)
	public Ex04_Circle(double radius) {
		this.radius = radius;
	}

	// 풀생성자
	public Ex04_Circle(int x, int y, double radius) {
		super();
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	// 원의 크기
	double calcArea() {
		return Math.PI * radius * radius;
	}

	// 원의 둘레
	double calcCircum() {
		return 2 * Math.PI * radius;
	}

	void output() {
		System.out.println("중심 좌표 : (" + x + "," + y + ")");
		System.out.println("반지름 : " + radius);
		System.out.println("크기 : " + calcArea());
		System.out.println("둘레 : " + calcCircum());
	}

}
