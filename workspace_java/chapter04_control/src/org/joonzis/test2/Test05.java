package org.joonzis.test2;

public class Test05 {
	public static void main(String[] args) {
//		Test05.java
//		Q. 1 ~ 100 사이의 모든 정수 합계 출력하기

		int num = 0;
		int sum = 0;
		int sum2 = 0;
		
		

		while (true) {
			num++;
			if(num % 2 == 0) {
				sum += num;				
			}else {				
				sum2 += num;				
			}
			
			if (num == 100) {
				break;
			}
		}
		System.out.println("짝수의 합 " + sum);
		System.out.println("홀수의 합 " + sum2);

	}
}
