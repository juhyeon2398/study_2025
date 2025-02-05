package org.joonzis.ex;

public class Ex02_Rect {
	int width, height;
	boolean isSquare;

	public Ex02_Rect() {
		width = height = 1;
	}

	public Ex02_Rect(int side) {
		width = height = side;
	}

	public Ex02_Rect(int w, int h) {
		width = w;
		height = h;
	}

	int calcArea() {
		return width * height;
	}

	void output() {
		isSquare = width == height;
		System.out.println("너비 : " + width);
		System.out.println("높이 : " + height);
		System.out.println("크기 : " + calcArea());
		System.out.println("형태 : " + (isSquare ? "정사각형" : "직사각형"));
	}

}
