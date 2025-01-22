package org.joonzis.test;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
//		Q. 두 정수를 입력받아 a, b에 저장한 뒤 두 변수의 값을 교환하는 프로그램 구현
//		* 임시 변수 필요
		int temp = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("a 값을 입력해주세요 : ");
		int a = sc.nextInt();
		System.out.println("b 값을 입력해주세요 : ");
		int b = sc.nextInt();
		
		System.out.println("변환 전 a 값은 : " + a + ", 변환 전 b 값은 : " + b);
		temp = b;
		b = a;
		a = temp;
		System.out.println("변환 후 a 값은 : " + a + ", 변환 후 b 값은 : " + b);
		
		
	}
}
