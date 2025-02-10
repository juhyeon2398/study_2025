package org.joonzis.ex;

class Product{
	
	void info() {
		System.out.println("Product");
	}
}

class Computer extends Product {
	@Override
	void info() {
		System.out.println("computer");
	}
}
class Notebook extends Computer {
	@Override
	void info() {
		System.out.println("Notebook ");
	}
}

public class Ex01_polymorphism {
	public static void main(String[] args) {
		Product[] pro = new Product[20];
		pro[0] = new Computer();
		pro[1] = new Notebook();
		pro[0].info();
		pro[1].info();
	}
}
