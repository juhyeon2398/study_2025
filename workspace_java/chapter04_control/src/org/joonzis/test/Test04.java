package org.joonzis.test;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
//		Test04.java
//		Q. 문자를 하나 입력 받아 "대문자", "소문자", "아라비아 숫자", "일반 문자" 
//		구분해서 출력하기
//		아스키 코드표 참고
		
		String str = "";
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		
		System.out.println("문자 하나를 입력해주세요 : ");
		str = sc.next();
		ch = (int) str.charAt(0);
		
		if(ch >= 64 && ch < 91) {
			System.out.println("대문자");
		}else if(ch >= 97 && ch < 123) {
			System.out.println("소문자");
		}else if(ch >= 47 && ch < 58) {
			System.out.println("아라비아 숫자");
		}else {
			System.out.println("일반문자");
		}
		
	}
}
