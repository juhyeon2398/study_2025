package org.joonzis.ex;

public class Ex03_while {
	public static void main(String[] args) {
		
		int num = 0;
		
//		while (num>0) {
//			System.out.println(num);
//			num--;
//		}
		
		while (true) {
			if(num == 10) {
				break;
			}else {
				System.out.println(num);
			}
			num++;
		}
	}
}
