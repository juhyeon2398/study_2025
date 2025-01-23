package org.joonzis.test;

import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
//		Test06.java (switch문)
//		Q. 권한을 출력하기
//			3 수준 : 실행, 쓰기, 읽기 / 2수준 : 쓰기, 읽기 / 1수준 : 읽기
//			실행 예)
//			수준입력 >> 3
//			출력 : 실행, 쓰기, 읽기
//		
		int grade = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("수준입력 >> ");
		grade = sc.nextInt();
		
		switch (grade) {
		case 1:
			System.out.println("읽기");
			break;
		case 2:
			System.out.println("쓰기, 읽기");
			break;
		case 3:
			System.out.println("실행, 쓰기, 읽기");
			break;
		default:
			break;
		}
		
		
	}
}
