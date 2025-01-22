package org.joonzis.test;

import java.util.Scanner;

public class Test07 {
	public static void main(String[] args) {
//		Q. 섭씨 온도를 입력 시 화씨 온도로 변환하는 프로그램 구현
//		* 화씨 : 섭씨 * 9/5 + 32
		Scanner sc = new Scanner(System.in);
		
		double tempC = 0;
		double tempF = 0;
		
		System.out.println("섭씨 온도를 입력해주세요 : ");
		tempC = sc.nextDouble();
		tempF = tempC*9/5 + 32;
		System.out.println("해당 온도의 화씨는 "+ tempF +"입니다." );
	}
}
