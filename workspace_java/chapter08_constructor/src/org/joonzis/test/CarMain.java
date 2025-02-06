package org.joonzis.test;

public class CarMain {
	public static void main(String[] args) {
		
		Car car = new Car("테슬라", "빨간색");
		car.output();
		
		System.out.println("=====================");
		Car car2 = new Car("아우디", "검은색",2021);
		car2.output();
		
	}
}
