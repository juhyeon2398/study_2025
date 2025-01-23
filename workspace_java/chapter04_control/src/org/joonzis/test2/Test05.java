package org.joonzis.test2;

public class Test05 {
	public static void main(String[] args) {
//		Test05.java
//		Q. 1 ~ 100 사이의 모든 정수 합계 출력하기

		int num = 0;
		int sum = 0;

		while (true) {
			num++;
			sum += num;
			System.out.println(num + ". " + sum);
			
			if (num == 100) {
				break;
			}
		}

	}
}
