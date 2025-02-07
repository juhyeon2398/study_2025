package org.joonzis.ex;

class Mother{
	public Mother() {
		System.out.println("Mother 객체 생성");
	}
}

class Son extends Mother {
	public Son() {
		System.out.println("Son 객체 생성");
	}
	
	void doSon() {
		System.out.println("doSon() 호출");
	}
}

public class Ex03_Constructor {
	public static void main(String[] args) {
		Son son = new Son();
		son.doSon();
	}
}
