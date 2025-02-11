package org.joonzis.ex;

public class Ex06_exception {
	public static void main(String[] args) {
		try {
			
			divide(5, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	public static void divide (int num1, int num2) throws ArithmeticException{
		System.out.println("몫 : " + (num1/num2));
		System.out.println("나머지 : " + (num1%num2));
	}
}
