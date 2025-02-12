package org.joonzis.ex;

class Computer {
	private String model;
	private int price;

	public Computer(String model, int price) {
		this.model = model;
		this.price = price;
	}

	@Override
	public String toString() {
		return "모델 : " + model + ", 가격 : " + price;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Computer) {
			Computer another = (Computer) obj;
			return model.equals(another.model) && price == another.price;
		} else {
			return false;
		}
	}
}

public class Ex02_Object_equals {
	public static void main(String[] args) {
		Computer com1 = new Computer("삼성", 100);
		Computer com2 = new Computer("삼성", 100);
		// 1. == : 참조 비교 (주소 비교)
		if (com1 == com2) {
			System.out.println("같음");
		} else {
			System.out.println("다름");
		}

		// 2. equals()
		if (com1.equals(com2)) {
			System.out.println("같음");
		} else {
			System.out.println("다름");
		}
	}
}
