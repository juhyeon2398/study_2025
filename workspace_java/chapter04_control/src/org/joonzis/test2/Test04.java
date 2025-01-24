package org.joonzis.test2;


public class Test04 {
	public static void main(String[] args) {
//		Test04.java
//		Q. 전체 구구단 출력하기_2
//		ex) 2x1 = 2 	3x1 = 3 	...		9x1 = 9
//			2x2 = 4		3x2 = 6		...		9x2 = 18
//			...
//			2x9 = 18	3x9 = 27 	...		9x9 = 81

	
		for (int i = 1; i < 10; i++) {
			for(int j = 2; j < 10; j++) {
				System.out.print(j +" x "+ i +" = "+ (j * i) + "\t");
			}
			System.out.print("\n");
		}
	}
}
