package org.joonzis.ex;

public class Ex04_do_while {
	public static void main(String[] args) {
		// 0~9까지 출력
		int num = 0;
		do {
			System.out.println(num);
			num++;
			if(num == 10) {
				break;
			}
		} while (true);

		do {
			System.out.println(num);
			num--;
		} while (num >= 0);
	}
}
