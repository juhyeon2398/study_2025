package org.joonzis.test;

import java.util.Arrays;
import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {

//Test05. java
//Q. int[] arr = {13, 22, -3, 92, 55, 5}
//	배열에서 값을 바꾸고 싶은 인덱스 2개를 선택하여
//	서로 값을 바꾸어 값들을 출력

		int[] arr = { 13, 22, -3, 92, 55, 5 };
		int tmp = 0;
		int num1 = 0;
		int num2 = 0;

		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 수 입력 >>");
		num1 = sc.nextInt();
		System.out.println("두번째 수 입력 >>");
		num2 = sc.nextInt();

		System.out.println("변경 전 "+Arrays.toString(arr));
		
		tmp = arr[num1];
		arr[num1] = arr[num2];
		arr[num2] = tmp;

	
		System.out.println("변경 후 "+Arrays.toString(arr));
	}
}
