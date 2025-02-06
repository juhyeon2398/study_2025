package org.joonzis.test;

//Ring.java				
//필드 - Circle inner, Circle outer
//메소드 - Constructor, output

public class Ring {
	Circle inner;
	Circle outer;

	public Ring() {
	}

	public Ring(Circle inner, Circle outer) {
		super();
		if (inner.radius > outer.radius) {
			this.inner = outer;
			this.outer = inner;
		} else {
			this.inner = inner;
			this.outer = outer;
		}
	}
	
	double ringArea() {
		return outer.calcArea() - inner.calcArea();
	}

	void output() {
		System.out.println("++ inner ++");
		inner.output();

		System.out.println("==============================");

		System.out.println("++ outer ++");
		outer.output();

		System.out.println("==============================");
		System.out.println("링의 넓이 : " + ringArea());
		

	};
}
