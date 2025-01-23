package org.joonzis.test2;

import java.util.Scanner;

public class Test07 {
	public static void main(String[] args) {
//		Test07.java
//		Q.두 정수를 입력 받아 두 정수 사이의 모든 정수의 합계 출력하기
//		    입력 순서와 무관하게 동일한 결과를 출력 
//		 	실행 예1)
//			첫 번째 정수 >> 1
//			두 번째 정수 >> 10
//			1부터 10까지 모든 정수의 합은 55입니다.
//			실행 예2)
//			첫 번째 정수 >> 10
//			두 번째 정수 >> 1
//			1부터 10까지 모든 정수의 합은 55입니다.

		int firstNum = 0;
		int secondNum = 0;
		int tmp = 0;
		int sum = 0;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("첫 번째 정수 >>");
			firstNum = sc.nextInt();
			System.out.println("두 번째 정수 >>");
			secondNum = sc.nextInt();

			if (firstNum == secondNum) {
				System.out.println("두 정수를 다르게 입력해주세요 : ");
			} else {
				break;
			}
		}

		if (firstNum > secondNum) {
			tmp = firstNum;
			firstNum = secondNum;
			secondNum = tmp;
		}

		for (int i = firstNum; i <= secondNum; i++) {
			sum += i;
			System.out.println(sum);
		}

	}
}
