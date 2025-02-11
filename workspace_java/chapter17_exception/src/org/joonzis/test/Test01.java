package org.joonzis.test;

import java.util.Random;
import java.util.Scanner;

//Q1. Test01.java		
//사용자로부터 10이상의 정수를 입력 받아 난수 (0 ~ 9)로 나눈결과를 출력하시오.
//위과정을 100번 반복하여 출력하며, 나눌 수없는 경우에는 나눈 결과를 0으로 대신출력한다.

public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		for (int i = 0; i < 100; i++) {
			System.out.println();
			int selNum = sc.nextInt();
			int ranNum = r.nextInt(10);
			
			try {
				System.out.println(selNum/ranNum);
			} catch (ArithmeticException e) {
				System.out.println("0으로 나누어진 상황");
				
			}
		}		
	}
}
