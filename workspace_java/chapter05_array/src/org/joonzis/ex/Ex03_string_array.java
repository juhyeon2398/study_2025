package org.joonzis.ex;

import java.util.Scanner;
import java.util.Arrays;

public class Ex03_string_array {
	public static void main(String[] args) {
		// 크기 3의 문자열 배열 names를 생성
		// 스캐너로부터 이름을 입력받아
		// "입력한 이름 : "출력
		// 일반 for, 향상 for
		
		String[] strArr = new String[3];
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i< strArr.length;i++) {
			strArr[i] = sc.next(); 
		}
		
		System.out.println(Arrays.toString(strArr));
		
		for (String name : strArr) {
			System.out.print(name);
		}
	}
}
