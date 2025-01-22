package org.joonzis.ex;

public class Ex01_Variable {
	public static void main(String[] args) {

		// 주석 : 실행과 상관없이 코드에 설명을 붙이는 것
		// 1. // : // 이후 라인 끝까지 주석으로 인지
		// 2. /**/ : 사이에 있는 모든 범위를 주석으로 인지

		// 1. 변수 선언( 선언과 초기화 동시 진행 )
		int num = 0;
		float num2 = 0f;
		double num3 = 0;
		char ch = 0;
		char ch2 = 'a';
		int ch3 = 'a';
		String str1 = null;
		String str2 = "hi";

		System.out.println("1. " + num);
		System.out.println("1. " + num2);
		System.out.println("1. " + num3);
		System.out.println("1. " + ch);
		System.out.println("1. " + ch2);
		System.out.println("1. " + ch3);
		System.out.println("1. " + str1);
		System.out.println("1. " + str2 + "\n");

		// 2. 다른 값 대입
		num = 100;
		num2 = 1.5f;
		num3 = 1.5;
		ch = '한';
		str1 = "Hello";
		str2 = "JAVA";

		System.out.println("2. " + num);
		System.out.println("2. " + num2);
		System.out.println("2. " + num3);
		System.out.println("2. " + ch);
		System.out.println("2. " + ch2);
		System.out.println("2. " + ch3);
		System.out.println("2. " + str1);
		System.out.println("2. " + str2);

		// 3. 스코프 (범위)
		// 1) 지역 변수 : 코드블록 {} 내에서만 접근 가능 벗어나면 소멸
		// 2) 전역 변수 : 모든 지역에서 사용 가능

		{
			int a = 10;
			System.out.println("코드 내 a = " + a);
		}

	}
}
