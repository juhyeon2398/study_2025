package org.joonzis.ex;

public class Ex01_Rect {
	// 필드
	int width, height;
	boolean isSquare;

	void setFields(int w, int h) {
		width = w;
		height = h;
		isSquare = width == height;
	}

	void setFields(int side) {
		width = height = side;
		isSquare = true;
	}

	int calcArea() {
		return width * height;
	}
	
	void output () {
		//너비, 높이 ,정사각형 or  정사각형, 크기
		isSquare = (width == height);
		System.out.println("너비 >> "+ width);
		System.out.println("높이 >> "+ height);
		System.out.println(isSquare ? "정사각형입니다." : "직사각형입니다.");
		System.out.println("크기 >> "+ calcArea());
	}
}
