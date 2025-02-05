package org.joonzis.ex;

public class Ex02_LocalMain {
	public static void main(String[] args) {
		Ex02_Local ex = new Ex02_Local();
		ex.setLocalInfo("홍길동", 21, "1234561234567");
		ex.output();

		System.out.println("====================");

		Ex02_Local ex2 = new Ex02_Local();
		ex2.setLocalInfo("김철수", 28);
		ex2.output();
		
		System.out.println("====================");

		Ex02_Local ex3 = new Ex02_Local();
		ex3.setLocalInfo("홍길동", 21, "123456-5234567");
		ex3.output();
	}
}
