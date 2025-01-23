package org.joonzis.test;

import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
//		Test05.java
//		Q. 알파벳을 하나 입력 받아 대문자가 입력되면 소문자로 변환해서 출력하고, 
//		   소문자가 입력되면 대문자로 변환해서 출력하고
//		   	나머지 문자들은 그대로 출력하기
//		★아스키 코드  
//		97~122 : 소문자,
//		 65~90 : 대문자, 
//		 48~57 : 숫자
		
		String str = "";
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		
		System.out.println("문자 하나를 입력해주세요 : ");
		str = sc.next();
		ch = (int) str.charAt(0);
		
		if(ch >= 64 && ch < 91) {
			System.out.println(str.toLowerCase());
		}else if(ch >= 97 && ch < 123) {
			System.out.println(str.toUpperCase());
		}else {
			System.out.println(str);
		}
		
	}
}
