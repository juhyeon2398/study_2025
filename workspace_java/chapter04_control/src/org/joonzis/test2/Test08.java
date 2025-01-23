package org.joonzis.test2;

import java.util.Scanner;

public class Test08 {
	public static void main(String[] args) {
//		Test08.java
//		Q.Up-Down 게임
//			1 ~ 100 사이에서 임의의 숫자를 하나 결정한 뒤
//			해당 숫자를 맞추는 게임
//			입력 받은 숫자의 크기에 따라 "Up!", "Down!", "Answer!" 로 나눠서 출력하고
//			맞출때까지 몇 번 진행했는지 횟수도 함께 출력
//			실행 예)
//			입력 >> 30
//			Up!
//			입력 >> 40
//			Down!
//			입력 >> 35
//			Down!
//			입력 >> 33
//			Answer!
//			총 4회만에 성공!
		int secretNum = 56;
		int answer = 0;
		int count = 0;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("입력 >>");
			answer = sc.nextInt();

			count++;
			if (answer > secretNum) {
				System.out.println("Down!!");
			} else if(answer < secretNum) {
				System.out.println("Up!!");
			}else {
				System.out.println("Answer!!");
				System.out.println("총"+count+"회만에 성공~");
				break;
			}
		}
	}
}
