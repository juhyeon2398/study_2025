package org.joonzis.test;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
//		Q. 나이를 입력받아 "성인" 또는 "미성년자" 출력
		Scanner sc = new Scanner(System.in);

		System.out.println("나이를 입력해주세요 : ");
		int age = sc.nextInt();

		boolean result = age >= 20;
		System.out.println(result ? "성인" : "미성년자");
	}
}
