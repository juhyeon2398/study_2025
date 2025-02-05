package org.joonzis.ex;

/*
 * 풀 생성자 자동 완성
 * 1. 우클릭 > Source > Generate Constructor using fields...
 * 		-> Alt + Shift + s  단축키와 같음
 * 2. 사용할 필드들을 선택한 후 Generate
 */
public class Ex03_Person {
	int age;
	String name;
	double height;
	char gender;

	public Ex03_Person() {
	}

	public Ex03_Person(int age, String name, double height, char gender) {
		super();
		this.age = age;
		this.name = name;
		this.height = height;
		this.gender = gender;
	}

	void output() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("키 : " + height);
		System.out.println("성별 : " + gender);
	}

}