package org.joonzis.ex;

public class Ex01_RectMain {
	public static void main(String[] args) {
		Ex01_Rect ex = new Ex01_Rect();
		ex.output();
		System.out.println("======================");
		Ex01_Rect ex2 = new Ex01_Rect(2);
		ex2.output();
		System.out.println("======================");
		Ex01_Rect ex3 = new Ex01_Rect(3, 2);
		ex3.output();
	}
}
