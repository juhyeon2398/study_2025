package org.joonzis.test;

import java.util.Scanner;

public class Test08 {
	public static void main(String[] args) {
//		Q. 특정 년도를 입력 받아서 해당 년도가 윤년인지 판단하는 프로그램 구현
//		* 윤년의 조건 : 연도가 4로 나누어지고, 100으로 나누어 떨어지지 않거나 400으로 나누어 떨어짐.
		Scanner sc = new Scanner(System.in);

		System.out.println("년도를 입려하세요 : ");
		int date = sc.nextInt();
		boolean result = date % 4 == 0 && (date % 100 != 0 || date % 400 == 0);

		System.out.println(result ? "윤년 입니다." : "윤년이 아닙니다.");
	}
}
