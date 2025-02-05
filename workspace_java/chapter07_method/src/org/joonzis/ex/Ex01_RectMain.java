package org.joonzis.ex;

public class Ex01_RectMain {
	public static void main(String[] args) {
		Ex01_Rect ex = new Ex01_Rect();
		
		ex.setFields(20,20);
		ex.output();
		System.out.println("==============");
		
		Ex01_Rect ex2 = new Ex01_Rect();
		ex2.setFields(30);
		ex2.output();
	}
}
