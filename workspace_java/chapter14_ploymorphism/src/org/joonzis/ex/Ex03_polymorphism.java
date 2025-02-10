package org.joonzis.ex;

class Animal {
	public Animal() {
		// TODO Auto-generated constructor stub
	}

	public void move() {
	}
}

class Dog extends Animal {
	@Override
	public void move() {
		System.out.println("강아지 움직인다.");
	}
}

class Dolphin extends Animal {
	@Override
	public void move() {
		System.out.println("돌고래 헤엄친다.");
	}
}

class Eagle extends Animal {
	@Override
	public void move() {
		System.out.println("독수리 헤엄친다.");
	}

	public void fly() {
		System.out.println("난다.");
	}
}

public class Ex03_polymorphism {
	public static void main(String[] args) {
		Animal[] ani = new Animal[3];

		ani[0] = new Dog();
		ani[1] = new Dolphin();
		ani[2] = new Eagle();

		for (int i = 0; i < ani.length; i++) {
			ani[i].move();
		}

		// 강제형변환
		if(ani[2] instanceof Eagle) {
			Eagle eagle = (Eagle) ani[2]; // 방식 1
			((Eagle) ani[2]).fly();  // 방식 2
		}
	}
	
}
