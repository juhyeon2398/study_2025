package org.joonzis.ex;

public class Ex07_continue {
	public static void main(String[] args) {
		int num = 0;
		while (true) {
			num++;

			if (num % 3 == 0) {
				continue;
			}
			if (num > 10) {
				break;
			}
			System.out.println(num);
		}
	}
}
