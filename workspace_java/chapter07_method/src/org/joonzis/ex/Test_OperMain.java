package org.joonzis.ex;

public class Test_OperMain {
	public static void main(String[] args) {
		Test_Oper oper = new Test_Oper();

		oper.plus(20, 30);
		oper.minus();
		oper.multi();
		System.out.println(oper.val1 + " / " + oper.val2 + " = " + oper.div());
	}
}
