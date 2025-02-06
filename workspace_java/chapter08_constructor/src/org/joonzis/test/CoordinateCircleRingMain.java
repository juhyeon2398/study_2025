package org.joonzis.test;

public class CoordinateCircleRingMain {
	public static void main(String[] args) {

		// 하위 클래스는 선언하지 않고 값만 넘겨주어도 된다.
		Coordinate codi = new Coordinate(6, 5);
		Circle c = new Circle(codi, 30);
		Circle c2 = new Circle(codi, 20);
		Ring r = new Ring(c, c2);

		r.output();
	}
}
