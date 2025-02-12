package org.joonzis.ex;

public class Ex01_mainThread {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);
				System.out.println("메인 Thread" + (i + 1) + "번 째 출력");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
