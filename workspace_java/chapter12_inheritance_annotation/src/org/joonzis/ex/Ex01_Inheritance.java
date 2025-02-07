package org.joonzis.ex;

// 부모
class Parent {
	int number;

	void doParent() {
		System.out.println("doParent() 호출");
	}
}

// 자식
class Child extends Parent {
	void doChild() {
		System.out.println("Child() 호출");
	}
}

public class Ex01_Inheritance {
	public static void main(String[] args) {
		Child child = new Child();
		child.number = 10;
		System.out.println(child.number);
		
		child.doChild();
		child.doParent();
	}
}
