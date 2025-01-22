package org.joonzis.ex;

public class Ex02_Variable_boundary {
	
	//임의 사용	
	static double PI = 3.14;
	
	public static void main(String[] args) {
		int value = 10;
		int sum = value + 30;
		
		System.out.println(sum);
//에러		System.out.println(result);
		System.out.println(PI);
	}
	
	public void local() {
		int result = 100;
	}
}
