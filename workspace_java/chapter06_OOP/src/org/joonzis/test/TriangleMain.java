package org.joonzis.test;

import java.util.Scanner;

//Q3. 
//클래스 Triangle 
//- 필드 : width, height
//- 메소드 : init(너비, 높이 입력), info(너비, 높이, 크기 출력), 
//			calcArea(w*h/2 넓이계산 후 리턴)
//클래스 TriangleMain
//- 메소드  : main
//값을 입력 받아서 (Scanner) 확인 
//파일을 하나만 사용

class Triangle {
	int width, height;
	Scanner sc = new Scanner(System.in);

	void init() {
		System.out.print("너비를 입려하세요 >> ");
		width = sc.nextInt();
		System.out.print("높이를 입려하세요 >> ");
		height = sc.nextInt();
	}

	void info() {
		System.out.println("너비 : " + width + ", 높이 : " + height);
	}

	double calcArea() {
		return width * height / 2.0;
	}
}

class Triangle2 {

	void info(double setWidth, double setHeight) {
		System.out.println("너비 : " + setWidth + ", 높이 : " + setHeight);
		System.out.println();
		System.out.println("넓이 : "+calcArea(setWidth, setHeight));
	}

	double calcArea(double setWidth, double setHeight) {
		return setWidth * setHeight / 2.0;
	}
}

public class TriangleMain {
	public static void main(String[] args) {
		Triangle tri = new Triangle();
		Triangle2 tri2 = new Triangle2();

		tri.init();
		System.out.println();
		tri.info();
		System.out.println();
		System.out.println("넓이 : " + tri.calcArea());

		Scanner sc2 = new Scanner(System.in);

		System.out.print("너비를 입려하세요 >> ");
		double getWidth = sc2.nextDouble();
		System.out.print("높이를 입려하세요 >> ");
		double getHeight = sc2.nextDouble();

		System.out.println();
		tri2.info(getWidth, getHeight);

	}
}
