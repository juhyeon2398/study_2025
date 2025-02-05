package org.joonzis.ex;

public class Ex04_CircleMain {
	public static void main(String[] args) {

		Ex04_Circle ex = new Ex04_Circle();
		ex.output();

		System.out.println("=================");

		Ex04_Circle ex2 = new Ex04_Circle(10);
		ex2.output();

		System.out.println("=================");

		Ex04_Circle ex3 = new Ex04_Circle(5, 2, 10);
		ex3.output();
	}
}
