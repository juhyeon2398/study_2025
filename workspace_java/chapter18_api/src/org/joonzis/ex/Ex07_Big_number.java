package org.joonzis.ex;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Ex07_Big_number {
	public static void main(String[] args) {
		// int 최대 값
		System.out.println(Integer.MAX_VALUE);
		// Long최대 값
		System.out.println(Long.MAX_VALUE);

		// BigInteger 클래스를 활용하여 Long 타입 이상/이하 tkdd rksmd
		// 반드시 문자열 처리
		BigInteger a = new BigInteger("12344555555555555555555555");
		BigInteger b = new BigInteger("1234455555555555555555555555555555555555555555555");
		// BigInteger 필드
		System.out.println(BigInteger.ZERO);
		System.out.println(BigInteger.ONE);
		System.out.println(BigInteger.TEN);

		System.out.println(a.add(b));
		System.out.println(a.subtract(b));
		System.out.println(a.multiply(b));
		System.out.println(a.divide(b));

		// BigDecimal 클래스로 실수의 소수자리수를 제한 없이 사용가능
		double d = 1.123454334634124;
		System.out.println(d);
		BigDecimal e = new BigDecimal("1.1231241724812648712468127468");
		System.out.println(e);
	}
}
