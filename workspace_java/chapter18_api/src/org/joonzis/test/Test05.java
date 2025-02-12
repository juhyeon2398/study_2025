package org.joonzis.test;

import java.util.Scanner;

//Q5.Test05.java
//성(lastName), 이름(firstName)을 각각 입력 받아
//하나의 이름(fullName)을 완성하시오. StringBuffer 클래스를 이용하시오.
//위의 방식으로 두 이름을 입력 받아 두 이름(fullName)의 동등 비교를 진행하시오.

public class Test05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("성을 입력하세요 >> ");
		String lastName = sc.next();
		System.out.print("이름을 입력하세요 >> ");
		String firstName = sc.next();
		StringBuffer fullName = new StringBuffer();
		
		fullName.append(lastName);
		fullName.append(firstName);

		System.out.println(fullName.toString());
		System.out.println(fullName.toString());
	}
}
