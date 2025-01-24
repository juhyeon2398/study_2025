package org.joonzis.test;

import java.util.Scanner;

public class Test07 {
	public static void main(String[] args) {
//		Test07.java (switch문)
//		Q. 월을 입력 받아 일을 출력하기
//			실행 예)
//			월 입력 >> 10
//			출력 : 10월은 31일 까지 있습니다.

		int date = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("월 입력 >> ");
		date = sc.nextInt();

		String day30 = "월은 30일까지 있습니다.";
		String day31 = "월은 31일까지 있습니다.";

//		break 사용에 따라 간략하게 표현 가능
		switch (date) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println(date + day31);
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println(date + day30);
			break;
		case 2:
			System.out.println(date + "월은 28일까지 있습니다.");
			break;
		default:
			break;
		}

	}
}
