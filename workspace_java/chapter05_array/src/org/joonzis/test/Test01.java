package org.joonzis.test;

import java.util.Arrays;
import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
//		Test01.java
//		Q. 임의의 정수값 5개를 저장한 배열 중에서 인덱스가 1인 곳의 값을 출력
		
		int[] arr = new int[5];
		
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("첫번째 항목 : " + arr[0]);
	}
}
