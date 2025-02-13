package org.joonzis.ex;

// <T> : 자료형 ex) int 형을 넣고 싶으면 Integer를 사용해야함
class Bag<T> {
	private T obj;

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
}
class Ball {}
class Pen {}

public class Ex02_Generic {
	public static void main(String[] args) {
		Bag<Ball> bag = new Bag<>();
		bag.setObj(new Ball());

		Ball ball = bag.getObj();
		// 제네릭을 사용하면 캐스팅이 필요없다.
	}
}
