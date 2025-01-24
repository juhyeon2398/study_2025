package org.joonzis.ex;

import java.util.Arrays;

public class Ex01_primitive_array {
	public static void main(String[] args) {
		// 정수형 arr1 이라는 배열을 선언(크기3)
		int[] arr1 = new int[3];

		// 정수형 arr2 이라는 배열을 선언(10,20,30의 값으로 초기화)
		int[] arr2 = { 10, 20, 30 };

		// 배열 내 데이터 확인
		// 1. Arrays.toString() 메소드 사용
		// 값만 확인하는 용도
		System.out.println(Arrays.toString(arr1));

		// 2. 배열 내 모든 인덱스 접근
		// 값을 저장하거나, 꺼내기 가능
		// 주로 반복문과 같이 사용
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}

	}
}
