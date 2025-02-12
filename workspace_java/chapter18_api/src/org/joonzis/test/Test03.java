package org.joonzis.test;

//Q3. Test03. java
// Coordinate 클래스
// 필드 : int x, int y;
// 메소드 : Constructor, equals()
// Circle 클래스
// 필드 : Coordinate center, double radius
// 메소드 : Constructor, equals()
//new Circle(0, 0, 1.5) // 중심 좌표[0,0], 반지름 : 1.5

class Coordinate {
	private int x, y;

	public Coordinate() {
	}

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean equals() {
		return false;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}

class Circle {
	private Coordinate center;
	private double radius;

	public Circle(int x, int y, double radius) {
		this.center = new Coordinate(x, y);
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "중심 좌표 : [" + center.getX() + "," + center.getY() + "] , 반지름 : " + this.radius;
	}

	public boolean equals() {
		return false;
	}
}

public class Test03 {
	public static void main(String[] args) {
		Circle c = new Circle(0, 0, 1.5);
		System.out.println(c.toString());
	}
}
