package org.joonzis.test;

import java.util.Scanner;

//Q2. Test02.java	
//나이를 입력 받아 출력하시오. 
//나이가 0 ~ 150 사이의 범위를벗어나면 AgeException 클래스를 이용하여 예외를 처리하시오.
//나이를 입력 받기 위해 int getAge() 메소드를 이용하시오.

class AgeException extends Exception {
	private static final long serialVersionUID = 1L;

	int errCode;

	public AgeException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}

	public int getErrCode() {
		return errCode;
	}
}

public class Test02 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			int age = getAge();
			System.out.println("나이는" + age + "살 입니다.");
		} catch (AgeException e) {
			System.out.println(e.getMessage());
		} finally {
			if(sc != null) {
				sc.close();
			}
		}
	}

	public static int getAge() throws AgeException {
		System.out.println("나이 입력 (0 ~ 150) >> ");
		int age = sc.nextInt();

		if (age < 0 || age > 150) {
			throw new AgeException("입력 가능한 나이는 0~150입니다.", 100);
		}

		return age;
	}
}
