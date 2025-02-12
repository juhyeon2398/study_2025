package org.joonzis.test;

import java.math.BigInteger;

//Q6.Test06.java
//1! ~ 99! 까지 전체 결과를 출력하시오.
//1! (1 팩토리얼) = 1
//2! (2 팩토리얼) = 1 * 2 = 2
//3! (3 팩토리얼) = 1 * 2 * 3 = 6
//4! (4 팩토리얼) = 1 * 2 * 3 * 4 = 24
//...
//n!: (n-1) * n
//
//ex)
//1! = 1
//2! = 2
//3! = 6
//4! = 24
//5! = 120
//...

public class Test06 {
	public static void main(String[] args) {
		
		for (int i = 1; i < 100; i++) {
			BigInteger a = new BigInteger("1");
			for (int j = 1; j <= i; j++) {
				a = a.multiply(BigInteger.valueOf(j));
			}
			System.out.println(i + "! = " + a);
		}
		
		BigInteger num = new BigInteger("1");
		for (int i = 1; i <= 99; i++) {
			num = num.multiply(BigInteger.valueOf(i));
			System.out.println(num);
		}
	}
}
