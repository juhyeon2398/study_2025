package org.joonzis.test;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
//Test02.java
//Q. 필기와 실기 점수를 입력 받아 합격 유무 출력하기
//합격기준: 필기와 실기 점수 모두 70점 이상이거나, 평균이 80 이상시 "합격" 아니면 "불합격"

		int score1 = 0;
		int score2 = 0;
		double avg = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("필기점수를 입력해주세요 : ");
		score1 = sc.nextInt();
		System.out.println("실기점수를 입력해주세요 : ");
		score2 = sc.nextInt();

		avg = (score1 + score2) / 2.0;
		System.out.println("필기 : " + score1 + " 실기 : " + score2 +"\n평균 : " + avg);

		if ((score1 >= 70 && score2 >= 70) || avg >= 80) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}

	}
}
