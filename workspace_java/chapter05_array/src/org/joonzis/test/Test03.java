package org.joonzis.test;

public class Test03 {
	public static void main(String[] args) {
//		Test03.java
//		Q. Test02.java 의 값들을 모두 더하고, 총점과 평균을 출력

		int[] arr = { 10, 20, 50, 60, 13, 25, 97 };
		int sum = 0;
		double avg = 0.0;

		for (int num : arr) {
			sum += num;
		}
		avg = sum / (double) arr.length;

		System.out.println("해당 배열의 합은 " + sum + "이며 평균은 " + avg + "입니다.");
	}
}
