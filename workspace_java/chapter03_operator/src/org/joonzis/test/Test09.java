package org.joonzis.test;

import java.util.Scanner;

public class Test09 {
	public static void main(String[] args) {
//		Q. 밑변과 높이를 입력 받아 삼각형의 넓이를 출력하는 프로그램 구현
//		* 삼각형의 넓이 공식 : (밑변 * 높이) / 2
		Scanner sc = new Scanner(System.in);

		double bottom = 0;
		double height = 0;
		
		String strBottom = "30.3";
		String strHeight = "10.5";
		
		bottom = Double.parseDouble(strBottom);
		height = Double.parseDouble(strHeight);
		
//		System.out.println("밑변을 입력하세요. : ");
//		bottom = sc.nextDouble();
//		System.out.println("높이을 입력하세요. : ");
//		height = sc.nextDouble();

		double area = height * bottom / 2;
		
		System.out.println(height);
		System.out.println(bottom);
		System.out.println(area);

	}
}
