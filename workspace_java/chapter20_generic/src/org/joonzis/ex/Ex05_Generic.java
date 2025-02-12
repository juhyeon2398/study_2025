package org.joonzis.ex;

import java.util.Arrays;

class Container <T>{
	private T[] items;

	// 명확하지 않은 타입 체크이지만, 더 이상 경고 X
	@SuppressWarnings("unchecked")
	public Container(int capacity) {
		// 배열크기가 지정되지 않을경우 Object에서 담아서 타입변경을 한다.
		items = (T[]) (new Object[capacity]);
	}
	
	public void add(T item) {
		// 순차적으로 순회하다가 빈자리가 발견되면 그 자리에 저장
		// items 배열에 item 변수 저장
		for (int i = 0; i < items.length; i++) {
			if(items[i] == null)  {
				items[i] = item;
				break;
			}
		}
	}
	
	public T[] getItems() {
		return items;
	}
	
}
class Gun{
	private String model;

	public Gun(String model) {
		super();
		this.model = model;
	}
	@Override
	public String toString() {
		return model;
	}
}

public class Ex05_Generic {
	public static void main(String[] args) {
		Container<Gun> con = new Container<>(10);
		con.add(new Gun("11111111111"));
		con.add(new Gun("22222222222"));
		con.add(new Gun("33333333333"));
		System.out.println(Arrays.toString(con.getItems()));
		
	}
}
