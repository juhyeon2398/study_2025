package org.joonzis.ex;

import java.util.Scanner;

class Person {
	//필드
	char gender;
	int age;
	double height;
	String name;
	
	void info() {
		System.out.println("성별 : " + gender);
		System.out.println("나이 : " + age);
		System.out.println("키  : " + height);
		System.out.println("이름 : " + name);
	}
	
}

public class Ex02_PersonMain {
	public static void main(String[] args) {
		Person person = new Person();
		Person person2 = new Person();
		
		Scanner sc = new Scanner(System.in);
		person.gender = sc.next().charAt(0);
		person.age = sc.nextInt();
		person.height = sc.nextDouble();
		person.name = sc.next();
		
		person2.gender = '여';
		person2.age = 29;
		person2.height = 171.2;
		person2.name = "영희";
		
		person.info();
		System.out.println();
		person2.info();
		
	}
}
