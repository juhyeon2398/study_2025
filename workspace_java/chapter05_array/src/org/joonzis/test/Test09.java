package org.joonzis.test;

import java.util.Scanner;

public class Test09 {
	public static void main(String[] args) {

//		Test09.java
//		Q. 과목 이름을 입력받아 해당 과목 점수를 출력해주는 프로그램을 작성.
//			무한반복을 하다가 "그만"을 입력 받으면, 프로그램 종료
//		★	String[] subjectArr = {"Java", "Python", "Android", "JSP", "Javascript"};
//			int[] scoreArr = {95, 88, 78, 62, 55};
//		실행 예)
//		Java의 점수는 : 95

		Scanner sc = new Scanner(System.in);
		String[] subjectArr = { "Java", "Python", "Android", "JSP", "Javascript" };
		int[] scoreArr = {95, 88, 78, 62, 55};
		String input = "";
		
		while (true) {
			System.out.print("과목명을 입력해주세요 >> ");
			input = sc.next().toLowerCase();
			
			for (int i = 0; i < subjectArr.length; i++) {
				if(subjectArr[i].toLowerCase().equals(input)) {
					System.out.println(subjectArr[i]+"과목의 점수는 : "+scoreArr[i]);
				}
			}

			if(input.equals("그만")) {
				break;				
			}
		}
			
	}
}
