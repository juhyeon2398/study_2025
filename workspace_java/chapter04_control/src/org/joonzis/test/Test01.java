package org.joonzis.test;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
//		Test01.java
//		Q. 정수를 입력 받아 "짝수", "홀수" 구분해서 출력하기
//		   3의 배수는 "3의 배수"로 출력하기

		int input = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력해주세요 : ");
		input = sc.nextInt();

		if (input % 2 == 0) {
			if (input % 3 == 0) {
				System.out.println(input + ": 3의 배수이며 짝수입니다.");
			} else {
				System.out.println(input + ": 짝수입니다.");
			}
		} else {
			if (input % 3 == 0) {
				System.out.println(input + ": 3의 배수이며 홀수입니다.");
			} else {
				System.out.println(input + ": 홀수입니다.");
			}
		}

	}
}
