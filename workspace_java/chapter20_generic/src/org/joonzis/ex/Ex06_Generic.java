package org.joonzis.ex;

import java.util.Arrays;

class Basket<T> {
	private T[] foods;

	// 명확하지 않은 타입 체크이지만, 더 이상 경고 X
	@SuppressWarnings("unchecked")
	public Basket(int capacity) {
		// 배열크기가 지정되지 않을경우 Object에서 담아서 타입변경을 한다.
		foods = (T[]) (new Object[capacity]);
	}
	
	public void add(T food) {
		// 순차적으로 순회하다가 빈자리가 발견되면 그 자리에 저장
		// items 배열에 item 변수 저장
		for (int i = 0; i < foods.length; i++) {
			if(foods[i] == null)  {
				foods[i] = food;
				break;
			}
		}
	}
	
	public T[] getFoods() {
		return foods;
	}
}

class Food {}
class Apple extends Food {}
class Banana extends Food {}
class Bread extends Food {}
class Computer {}

public class Ex06_Generic {
	public static void main(String[] args) {
		Basket<Food> basket = new Basket<>(10);
		// 상속 받은 자식들은 업캥스팅 되어 가능
		basket.add(new Apple());
		basket.add(new Banana());
		basket.add(new Bread());
		System.out.println(Arrays.toString(basket.getFoods()));
//		basket.add(new Computer());
		
	}
}
