package org.joonzis.ex;

import java.util.Random;

public class Ex01_Random {
	public static void main(String[] args) {
		Random ran = new Random();

		System.out.println(ran.nextInt());
		// 난수 발생 (0 ~ 9);
		System.out.println(ran.nextInt(10));

		System.out.println(ran.nextInt(6)); // 0~5
		System.out.println(ran.nextInt(6) + 1); // 0~6
		System.out.println(ran.nextDouble()); // 0~0.999
		System.out.println(ran.nextDouble() * 10); // 0~9.999
		System.out.println((int) ran.nextDouble() * 10); // 0~9
		System.out.println((int) (ran.nextDouble() * 6) + 1); // 1~6
		
		int rnd = ((int)(Math.random()*6 +1));
		System.out.println(rnd);
	}
}
