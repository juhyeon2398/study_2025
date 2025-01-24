package org.joonzis.test;

import java.util.Arrays;
import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
//		Test04.java
//		Q. 길이가 5인 int형 배열 선언 후, 사용자로부터 콘솔입력 받아 해당 데이터 값을 모두 더해서 합을 출력하기
		
		int[] arr = new int[5];
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			System.out.println("인덱스 "+i+"번 입력 >> ");
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		System.out.println("입력받은 배열은"+Arrays.toString(arr)+"이며 배열의 합은 "+sum+"입니다.");
	}
}
