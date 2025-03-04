package org.test;

import java.util.Arrays;

public class Test04 {
	public static void main(String[] args) {
//		Q4. 피보나치 수열 20개를 출력하시오.
//		ex) 1, 1, 2, 3, 5, 8, 13, 21
		int[] arr = new int[20];
		for (int i = 0; i < 20; i++) {
			if(i < 2) {
				arr[i] = 1;
			}else {
				arr[i] = arr[i - 1] + arr[i - 2]; 				
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
}


