package org.joonzis.ex;

public class Test_Oper {
	double val1, val2;
	// 두 값을 이용하여 사칙연산하는 클래스
	// 1. 두 값을 전달받아 두 값의 합을 출력하는 plus메소드
	// 2. 전역 변수 두 값의 차을 출력하는 minus메소드
	// 3. 전역 변수 두 값의 곱을 출력하는 multi메소드
	// 4. 전역 변수 두 값의 나눈 값을 리턴하는 div메소드

	void plus(double val1, double val2) {
		this.val1 = val1;
		this.val2 = val2;

		double result = val1 + val2;
		System.out.println(val1 + " + " + val2 + " = " + result);
	}

	void minus() {
		double result = val1 - val2;
		System.out.println(val1 + " - " + val2 + " = " + result);
	}

	void multi() {
		double result = val1 * val2;
		System.out.println(val1 + " X " + val2 + " = " + result);
	}

	double div() {
		return val1 / val2;
	}

}
