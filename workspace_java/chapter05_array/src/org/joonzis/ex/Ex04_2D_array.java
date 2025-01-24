package org.joonzis.ex;

public class Ex04_2D_array {
	public static void main(String[] args) {
		//2행 3열 
		int[][] arr = {{1,2,3},{4,5,6}};
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.println(arr[i][j]);
			}
		}
		
		// 3행 n열 정수형 배열
		int[][] arr2 = {
				{1,2,3},
				{4,5},
				{6,7,8,9}
		};
		
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				System.out.print(arr2[i][j]);
			}
			System.out.println();
		}
	}
}
