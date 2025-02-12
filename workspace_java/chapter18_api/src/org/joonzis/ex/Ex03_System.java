package org.joonzis.ex;

public class Ex03_System {
	public static void main(String[] args) {

		// 반복 중 특정 회차가 되었을 때 시스템 종료
		for (int i = 0; i < 10; i++) {
			System.out.println("i");

			try {
				if (i == 4) {
					System.exit(i);
				}
			} catch (SecurityException e) {
				e.printStackTrace();
			}

		}
	}
}
