package org.joonzis.ex;

public class Ex02_RectMain {
	public static void main(String[] args) {
		Ex02_Rect ex = new Ex02_Rect(6, 2);
		ex.output();
		System.out.println("====================");
		Ex02_Rect ex2 = new Ex02_Rect(6);
		ex2.output();
		System.out.println("====================");
		Ex02_Rect ex3 = new Ex02_Rect();
		ex3.output();
	}
}
