package org.joonzis.test;

import java.util.Arrays;

public class Test07 {
	public static void main(String[] args) {

//		Test06.java
//		Q. Test05의 배열을 이용하여 배열 내 값들의 최소, 최대값을 출력

		int[] arr = { 13, 22, -3, 92, 55, 5 };
		int max = arr[0];
		int min = arr[0];

		for (int i : arr) {
			if (i > max)
				max = i;
			if (i < min)
				min = i;
		}

		System.out.println("최대값 :" + max);
		System.out.println("최소값 :" + min);

	}
}
