package org.joonzis.ex;

import java.util.Scanner;

public class Ex02_StudentMain {
	public static void main(String[] args) {
		Ex02_Student ex = new Ex02_Student("김씨","컴공");
		ex.input(new Scanner(System.in));
		ex.output();
	}
}
