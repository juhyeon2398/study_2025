package org.joonzis.ex;

import java.util.Scanner;

public class Ex01_input {
	public static void main(String[] args) {
		// 1. Scanner 객체(인스턴스) 생성
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 입력 >> ");
		String name = sc.nextLine();
		
		System.out.print("나이 입력 >> ");
		int age = sc.nextInt();
		
		System.out.print("키 입력 >> ");
		double height = sc.nextDouble();
		
		System.out.println("이름 : " + name );
		System.out.println("나이 : " + age	);
		System.out.println("키 : " + height);
	}
}
