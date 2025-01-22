package org.joonzis.ex;

import java.util.Scanner;

public class Ex04_operator03 {
	public static void main(String[] args) {
		int a = 10;
		System.out.println(a == 10 && a < 100); // true
		System.out.println(a != 10 || a < 100); // true
		System.out.println(!(a == 10)); // false

		int b = 10;
		boolean result = (a == 100) && (++b > 10);
		System.out.println("result : " + result + "," + "b : " + b);

		int age = 18;
		boolean isAdult = (age >= 20) ? true : false;

		int fee = isAdult ? 4000 : 2000;
		
		String id = "";
		//id 가 admin 이면 "인증성공"
		//아니면 "인증실패"
		
	
		
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력하세요 : ");
		id = sc.nextLine();
				
		boolean result2 = id.equals("admin");
		System.out.println(result2 ? "인증성공" : "인증실패");
	}
}
