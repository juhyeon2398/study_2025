package org.joonzis.ex;

interface Animal {
	public void move();

	public void eat(String food);
}

class Dog implements Animal {

	@Override
	public void move() {
		System.out.println("산책");
	}
	
	@Override
	public void eat(String food) {
		System.out.println(food+"먹음");
	}
}

public class Ex02_interface {
	public static void main(String[] args) {
		Animal animal = new Dog();
		animal.move();
		animal.eat("사료");
	}
}
