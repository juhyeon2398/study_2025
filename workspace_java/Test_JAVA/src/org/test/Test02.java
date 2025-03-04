package org.test;

public class Test02 {
	public static void main(String[] args) {
//		Q2. 1+(1+2)+(1+2+3)+(1+2+3+4)...(1+2+3+...+10)의 결과를 출력하시오.
		int num1 = 0;
		int num2 = 0;
		for (int i = 1; i <= 10; i++) {
			for (int j = i; j > 0; j--) {
				num1 += j;
			}
			num2 += num1;
			num1 = 0;
		}
		System.out.println(num2);
	}
}


