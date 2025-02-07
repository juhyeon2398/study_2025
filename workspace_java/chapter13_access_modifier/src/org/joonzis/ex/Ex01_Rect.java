package org.joonzis.ex;

public class Ex01_Rect {
	// 필드 width, height, isSquare

	// 메소드
	// 생성자() : 가로, 세로 1 고정
	// 생성자(int side) : 가로 세로 같은 값으로 저장
	// 생성자(w,h) : 가로, 세로 값 전달 받아 저장
	// int calcArea() : 사각형 크기 리턴
	// output() : 너비, 높이, 크기, 형태(정or직사각형)출력

	private int width, height;
	private boolean isSquare;

	public Ex01_Rect() {
		this(1,1);
	}

	public Ex01_Rect(int side) {
		this(side, side);
	}

	public Ex01_Rect(int width, int height) {
		this.width = width;
		this.height = height;
		isSquare = (width == height);
	}

	private int calcArea() {
		return width * height;
	}

	public void output() {
		System.out.println("너비 : " + width);
		System.out.println("높이 : " + height);
		System.out.println("넓이 : " + calcArea());
		System.out.println(isSquare ? "정사각형" : "직사각형");
	}

}
