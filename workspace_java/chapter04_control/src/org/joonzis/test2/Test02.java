package org.joonzis.test2;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
//		Test02.java
//		Q. 입력받은 구구단만 출력하기
//		ex) 4X1=4
//			4X2=8
//			4X3=12
//			4X4=16
//			...
		
		Scanner sc = new Scanner(System.in);
		System.out.println("출력할 구구단 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		
		for (int i = 1; i < 10; i++) {
			System.out.println(input +" x "+ i +" = "+ (input * i));
		}
	}
}
