package org.joonzis.test;

//Q2.
//클래스 Dog을 정의하시오.
//- 필드 : String name, String breed, int age
//- 메소드 : setDog(name, age) : 품종은 푸들
//		setDog(name, age, breed) 
//		info() - name, age, breed 출력
//클래스 DogMain을 정의하시오.

public class Dog {
	String name, breed;
	int age;

	void setDog(String name, String breed, int age) {
		this.name = name; // 이름
		this.age = age; // 나이
		this.breed = breed; // 품종
	}

	void setDog(String name, int age) {
		this.name = name; // 이름
		this.age = age; // 나이
	}

	void info() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("품종 : " + (breed == null ? "푸들" : breed));
	}
}
