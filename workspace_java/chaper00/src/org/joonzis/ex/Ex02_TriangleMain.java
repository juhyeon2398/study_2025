package org.joonzis.ex;

import java.util.Scanner;

public class Ex02_TriangleMain {
	public static void main(String[] args) {
		/*
		 * 1. 크기 3의 참조(Ex02_Triangle.java) 배열 arr 선언
		 * 2. 반복문을 이용하여 객체를 생성함과 동시에 값을 초기화 시킨다(스캐너 이용)
		 * 3. 반복문을 이용하여 각 객체의 정보 출력
		 * 
		 * ex)입력 ------
		 * 	 	너비 입력 >> 3
		 * 		높이 입력 >> 5
		 * 		(반복)
		 * 
		 * 	   출력 ------
		 * 		1번 삼각형 ----
		 * 		너비 : 3
		 * 		높이 : 5
		 *  	크기 : 7.5
		 *  	(반복)
		 */
		Ex02_Triangle[] arr = new Ex02_Triangle[3];
		Scanner sc = new Scanner(System.in);
		
		// 입력 for
		for(int i=0; i<arr.length; i++) {
			System.out.print("너비 입력 >> ");
			int width = sc.nextInt();
			System.out.print("높이 입력 >> ");
			int height = sc.nextInt();
			arr[i] = new Ex02_Triangle(width, height);
		}
		
		// 출력 for
//		for(int i=0; i<arr.length; i++) {
//			System.out.println((i+1) + "번 삼각형----");
//			arr[i].output();
//		}
		
		for(Ex02_Triangle semo : arr) {
			semo.output();
		}
		
		sc.close();
		
		
		
	}
}
