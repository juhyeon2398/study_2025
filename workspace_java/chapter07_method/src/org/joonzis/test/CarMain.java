package org.joonzis.test;

public class CarMain {
	public static void main(String[] args) {
		Car car = new Car();
		car.setFields("현대", "빨간색");
		car.output();

		System.out.println("=========================");

		Car car2 = new Car();
		car2.setFields("아우디", "회색", 2023);
		car2.output();

	}
}
