package org.joonzis.ex;

public class Ex01_Triangle {
	int width, height;
	// 메소드
	// 초기화, 크기 계산, 출력

	public Ex01_Triangle() {
		width = height = 1;
	}

	public Ex01_Triangle(int w, int h) {
		width = w;
		height = h;
	}
	
	double calcArea() {
		return width*height/2;
	}
	void output() {
		System.out.println("너비 : " + width);
		System.out.println("높이 : " + height);
		System.out.println("넓비 : " + calcArea());
	}
}
