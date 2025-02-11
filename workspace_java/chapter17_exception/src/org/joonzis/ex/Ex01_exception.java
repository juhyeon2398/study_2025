package org.joonzis.ex;

import java.util.InputMismatchException;
import java.util.Scanner;

// ArithmeticException
// 정수를 0으로 나눌경우 발생

public class Ex01_exception {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		try {
			System.out.print("정수1 입력  >> ");
			num1 = sc.nextInt();
			System.out.print("정수2 입력  >> ");
			num2 = sc.nextInt();
			System.out.println("덧샘 결과 >> " + (num1 + num2));
			System.out.println("뺄샘 결과 >> " + (num1 - num2));
			System.out.println("곱샘 결과 >> " + (num1 * num2));
			System.out.println("나눗샘 결과 >> " + (num1 / num2));
		} catch (ArithmeticException e) { // Exception e로 처리가능
			e.printStackTrace();
			System.out.println("0으로 나눌 수 없습니다.");
		} catch (InputMismatchException e) {
			System.out.println("정수 입력 부탁드립니다.");
		} finally {
			if(sc != null)  sc.close();
		}
		
	}
}
