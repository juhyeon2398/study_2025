package org.joonzis.test;

import java.util.Scanner;

//Cricle.java 			
//- 필드 : double radius
//- 메소드 : Constructor, calcArea, output
//CricleMain.java			
//Circle 3개 생성 (반지름 입력 받아서 처리), 가장 크기가 큰 Circle 출력
//★
//calcArea => Math.PI * Math.pow(radius, 2)
//output => 반지름, 크기 출력


public class CircleMain {
	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);

		Circle[] arr = new Circle[3];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Circle();
			arr[i].setRadius(sc.nextDouble());
		}
		
		for(Circle cir : arr) {
			cir.output();
			System.out.println("=================");
		}
		
	}
}
