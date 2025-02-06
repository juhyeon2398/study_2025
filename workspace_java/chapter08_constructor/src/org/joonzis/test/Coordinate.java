package org.joonzis.test;

//Q4.
//Coordinate.java			
//필드 - int x, int y
//메소드 - Constructor, output

public class Coordinate {
	int x, y;

	public Coordinate() {
	}

	public Coordinate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	void output() {
		System.out.println("x의 좌표 : " + x);
		System.out.println("y의 좌표 : " + y);
	}
}
