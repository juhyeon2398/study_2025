package org.joonzis.test2;

import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
//		Test06.java
//		Q. 1부터 입력 받은 양수 사이의 모든 정수의 합계 출력하기
//		      입력 받은 수가 2이상이 아니면 다시 입력 받도록 처리

		int inputNum = 0;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		while(inputNum < 2) {
			System.out.println("정수를 입력해주세요. :");			
			inputNum = sc.nextInt();
		}
			
		for(int i = 1; i < inputNum+1; i++) {
			sum += i;
			System.out.println(sum);
		}
	

	}
}
