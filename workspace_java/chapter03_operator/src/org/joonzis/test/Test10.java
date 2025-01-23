package org.joonzis.test;

import java.util.Scanner;

public class Test10 {
	public static void main(String[] args) {
//		Q. 변수 num에 숫자 데이터를 입력 받고, 각 자리수를 더하여 출력하는 프로그램 구현
//		* ex) num = 1234
//			1 + 2 + 3 + 4
		Scanner sc = new Scanner(System.in);

		int num = 0;
		int length = 0;
		int result = 0;
		String strNum = "";

		System.out.println("숫자 입력 : ");
		num = sc.nextInt();
		
		strNum = Integer.toString(num);
		length = strNum.length();
		for (int i = 0; i < length; i++) {
			result += Integer.parseInt(strNum.substring(i, i + 1));
			if(i == length-1) {
				System.out.println("최종 합은 :" + result);
			}else {
				System.out.println(result);
			}
		}
	}
}
