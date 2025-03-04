package org.test;

public class Test03 {
	public static void main(String[] args) {
//		Q3. 주어진 배열 내의 최대 값, 최소 값, 평균을 출력하시오.
		
		int[] array = {2,7,3,8,5};
		int max = array[0]; 
		int min = array[0];
		for (int i : array) {
			if(i > max) {
				max = i;
			}
			if(i < min) {
				min = i;
			}
		}
		
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		
	}
}
