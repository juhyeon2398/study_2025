package org.joonzis.test;

//Q2.
//클래스 Dog을 정의하시오.
//- 필드 : String name, String breed, int age
//- 메소드 : setDog(name, age) : 품종은 푸들
//		setDog(name, age, breed) 
//		info() - name, age, breed 출력
//클래스 DogMain을 정의하시오.

public class DogMain {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.setDog("초코", 3);
		dog.info();

		System.out.println("==============");
		Dog dog2 = new Dog();
		dog2.setDog("진돌이", "진돗개", 1);
		dog2.info();
	}

}
