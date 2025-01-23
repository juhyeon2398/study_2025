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
		
		String day30 =  "월은 30일까지 있습니다.";
		String day31 =  "월은 31일까지 있습니다.";
		
		switch (date) {
		case 1:
			System.out.println(date + day31);
			break;
		case 2:
			System.out.println(date+"월은 28일까지 있습니다.");
			break;
		case 3:
			System.out.println(date + day31);
			break;
		case 4:
			System.out.println(date + day30);
			break;
		case 5:
			System.out.println(date + day31);
			break;
		case 6:
			System.out.println(date + day30);
			break;
		case 7:
			System.out.println(date + day31);
			break;
		case 8:
			System.out.println(date + day31);
			break;
		case 9:
			System.out.println(date + day30);
			break;
		case 10:
			System.out.println(date + day31);
			break;
		case 11:
			System.out.println(date + day30);
			break;
		case 12:
			System.out.println(date + day31);
			break;
		default:
			break;
		}
		
		
	}
}
