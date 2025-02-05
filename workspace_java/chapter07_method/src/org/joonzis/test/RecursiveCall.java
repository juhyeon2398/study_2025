package org.joonzis.test;

import java.util.Scanner;

//Q3.
//클래스 RecursiveCall 을 정의하시오.
//- 필드  : X
//- 메소드 : recursive(n) -> n번 "Hello" 출력하기
//		 main
//★
//if-else 사용 - else 일 때 재귀 호출

public class RecursiveCall {

	static void recursive(int count) {
		if (count == 0) {
			System.out.println("종료");
			return;
		} else {
			System.out.println("Hello");
			count--;
			recursive(count);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		recursive(sc.nextInt());
	}
}
