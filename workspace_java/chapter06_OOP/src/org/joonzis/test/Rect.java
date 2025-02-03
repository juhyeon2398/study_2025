package org.joonzis.test;

import java.util.Scanner;

//Q2.
//클래스 Rect
//- 필드 : width, height
//- 메소드 : init(너비, 높이 입력), info(너비, 높이), 
//          calcArea(w*h, 넓이계산(크기) 출력)
//클래스 RectMain
//- 메소드 : main

public class Rect {
	int width;
	int height;
	Scanner sc = new Scanner(System.in);
	
	void init() {
		System.out.print("넓이를 입력하세요 >> ");
		width = sc.nextInt();
		System.out.print("높이를 입력하세요 >> ");
		height = sc.nextInt();
	}
	
	void calcArea() {
		System.out.println("너비 >> " + width);
		System.out.println("높이 >> "+ height);
		System.out.println("넓이 >> "+ width*height);
	}

	void info() {
		System.out.println("너비 >> " + width);
		System.out.println("높이 >> "+ height);
	}
}
