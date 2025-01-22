package org.joonzis.test;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
//		Q. 매출액과 등급("VIP", "일반")을 입력받아 등급이 "VIP"이면 매출액에서 20%를 할인하고
//		   "일반"이면 매출액에서 5%를 할인하는 프로그램 구현
		Scanner sc = new Scanner(System.in);
		
		System.out.println("매출액을 입력해주세요 : ");
		int money = sc.nextInt();
		
		System.out.println("등급을 입력해주세요 : ");
		String grade = sc.next();
		
		boolean vip = grade.equals("VIP") || grade.equals("vip");
		System.out.println(
				vip ? "VIP등급은 매출액의 20% 할인 되어" + money*0.8 +"입니다."
						: "일반등급은 매출액의 5% 할인 되어" + money*0.95 +"입니다."
		);
		
		
	}
}
