package org.joonzis.ex;

// 부모
class Person {
	void sleep() {
		System.out.println("잔다.");
	}

	void eat(String food) {
		System.out.println(food + "먹는다.");
	}
}

// 자식
class Student extends Person {
	void study() {
		System.out.println("공부");
	}
}

class Worker extends Person {
	void work() {
		System.out.println("일중");
	}
}

public class Ex02_Inheritance {
	public static void main(String[] args) {
		Student stu = new Student();
		stu.eat("급식");
		stu.study();
		stu.sleep();
		
		Worker worker = new Worker();
		worker.eat("점심");
		worker.work();
		worker.sleep();
	}
}
