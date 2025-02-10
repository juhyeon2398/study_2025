package org.joonzis.test;

public class Dog implements Animal {
	
	public Dog() {
	}
	
	@Override
	public void move() {
		System.out.println("산책");
	}

}
