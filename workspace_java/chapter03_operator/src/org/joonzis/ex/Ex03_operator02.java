package org.joonzis.ex;

public class Ex03_operator02 {
	public static void main(String[] args) {
		//시프트 
		int num = 8;
		System.out.println("왼쪽 시프트 : " + (num << 2));
		System.out.println("오른쪽 시프트 : " + (num >> 1));
		
		//증감 
		int val = 10;
		System.out.println(val);
		System.out.println(val++);
		System.out.println(++val);
	}
}
