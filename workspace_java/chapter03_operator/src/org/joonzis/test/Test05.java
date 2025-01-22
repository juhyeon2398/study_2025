package org.joonzis.test;

import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
//		Q. 하이픈 없이 주민등록번호를 입력받아 (정수, 문자열) "남자","여자" 출력하기
//		* String의 메소드 이용하기
//		* ex) charAt(), substring() 등
		Scanner sc = new Scanner(System.in);
		
		System.out.println("주민번호 13자리를 입력해주세요 : ");
		String num = sc.next();
		char sexNum = num.charAt(6);
		
		boolean result = (sexNum ==  '1' || sexNum == '2' || sexNum == '3' || sexNum == '4');
		String sexResult = (sexNum == '2' || sexNum == '4') ? "여자입니다." : "남자입니다."; 
		
		
		System.out.println(result ? sexResult : "다시입력하세요.");
	}
}
