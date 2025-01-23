package org.joonzis.test;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
//		Q. 성별을 의미하는 정수 값(1,3:남자, 2,4:여자)을 입력받아 "남자", "여자"출력하기
//		* 1~4 사이의 값으로 입력 받기 
//		* 홀수-남자 짝수-여자
		Scanner sc = new Scanner(System.in);

		System.out.println("성별 번호를 입력해주세요 : ");
		int sexNum = sc.nextInt();
		boolean result = (sexNum % 2 == 0);
		System.out.println(result ? "여자" : "남자");

	}
}
