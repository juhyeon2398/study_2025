package org.joonzis.ex;

class Person{
	public void eat(String food) {
		System.out.println(food+"먹는다.");
	}
	public void sleep() {
		System.out.println("잔다.");
	}
}
class Student extends Person{
	public void study() {
		System.out.println("공부한다.");
	}
}
class Worker extends Person{
	public void work() {
		System.out.println("일한다.");
	}
}


public class Ex04_polymorphism {
	public static void main(String[] args) {
		Person[] person = new Person[2];
		person[0] = new Student();
		person[1] = new Worker();
		
		person[0].eat("김치");
		person[0].sleep();
		
		if(person[0] instanceof Student) {
			((Student) person[0]).study();
		}
		System.out.println("============");
		
		person[1].eat("단무지");
		person[1].sleep();
		if(person[1] instanceof Worker) {
			((Worker) person[1]).work();
		}
	}
}
