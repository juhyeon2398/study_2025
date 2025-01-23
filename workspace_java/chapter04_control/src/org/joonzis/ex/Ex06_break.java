package org.joonzis.ex;

import java.util.Scanner;

public class Ex06_break {
	public static void main(String[] args) {
		//id를 입력받아서 id가 "admin"이면 "ID 일치" 출력 후 반목문 종료

		String id = "";
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("아이디를 입력해주세요.");
			id = sc.nextLine();
	
			if(id.equals("admin")) {
				System.out.println("ID가 일치합니다.");
				break;
			}
			System.out.println("ID가 일치하지 않습니다.");
		}
			
		
	}
}
