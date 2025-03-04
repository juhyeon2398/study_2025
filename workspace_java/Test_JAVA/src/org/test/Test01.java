package org.test;

public class Test01 {
	public static void main(String[] args) {
//		Q1. 1부터 20까지의 정수 중에서 2 또는 3의 배수가 아닌 수의 총합을 출력하시오.
		int result = 0;
		for (int i = 1; i <= 20; i++) {
			if(i % 2 != 0 && i % 3 != 0) {
				result += i;
			}
		}
		System.out.println(result);
	}
}
