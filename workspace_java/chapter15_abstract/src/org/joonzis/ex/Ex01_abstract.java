package org.joonzis.ex;

abstract class Animal{
	public void eat(String food) {
		System.out.println("aaaaaa");
	}
	
	abstract public void move();
}

class Dog extends Animal{

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	
}

public class Ex01_abstract {
	public static void main(String[] args) {
		// 추상 클래스는 new를 할 수 없다.
//		Animal animal = new Animal();
		Animal animal = new Dog();
		animal.eat("사료");
		animal.move();
	}
}
