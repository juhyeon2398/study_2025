package org.joonzis.ex;

import java.util.Scanner;
import java.util.Arrays;

public class Ex02_for_each {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		
		// 1. 개별적으로 한 개씩 삽입
		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		arr[2] = sc.nextInt();
		
		// for-each문 (향상 for문)
		// 배열크기 만큼 반복
		// 삽입 불가
		for(int num : arr) {
			System.out.println(num);
		}

		// 주의사항
		int[] arr2 = new int[3];
		for(int num : arr2) {
			System.out.println("입력 >> ");
			num = sc.nextInt();
		}
		
		for(int num: arr2) {
			System.out.println(num);
		}
	}
}
