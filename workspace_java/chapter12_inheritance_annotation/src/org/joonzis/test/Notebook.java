package org.joonzis.test;

//Q2. Test02.java 상속 관계로 구현하시오.
//Notebook.java				
//- 필드 : String model, int price, int battery
//- 메소드 : Constructor, output()	
//Tablet.java					
//- 필드 : String model, int price, int battery, String pen
//- 메소드 : Constructor, output()
//→ 부모클래스는 알아서 만들어보자!(Computer)
//**** Computer는 	battery 가 없다 ******

public class Notebook extends Computer {
	int battery;

	public Notebook() {}

	public Notebook(String model, int price, int battery) {
		super(model, price);
		this.battery = battery;
	}

	@Override
	void output() {
		super.output();
		System.out.println("베터리 : " + battery);
	}
}
