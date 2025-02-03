package org.joonzis.test;

import java.util.Arrays;
import java.util.Scanner;

public class Test08 {
	public static void main(String[] args) {

//		Test08.java
//		Q. 성적 관리 프로그램 
//		5명의 int형 점수를 저장하는 scores 배열을 선언하고, 점수를 입력받아 최대, 최소, 평균 점수를 출력하기
//		String형 배열 names를 선언하고, 학생 5명의 이름을 초기화 한 뒤 활용
//
//				Scanner sc = new Scanner(System.in);
//				String[] names = {"김씨", "이씨", "박씨", "최씨", "정씨"};
//				int[] scores = new int[5];
//
//		실행 예)
//		바트의 점수 입력 >> 70
//		리사의 점수 입력 >> 100
		Scanner sc = new Scanner(System.in);
		String[] names = { "김씨", "이씨", "박씨", "최씨", "정씨" };
		int[] scores = new int[5];
		for (int i = 0; i < names.length; i++) {
			System.out.print("학생이름을 입력해주세요 >> ");
			names[i] = sc.next();

			for (int j = 0; j < scores.length; j++) {
				System.out.print((j + 1) + "번 과목 점수를 입력하세요 : >> ");
				scores[j] = sc.nextInt();
			}
		}

		for (int i = 0; i < names.length; i++) {
			int max = scores[0], min = scores[0], sum = 0;
			double avg = 0.0;
			for (int j = 0; j < scores.length; j++) {
				if (max < scores[j])
					max = scores[j];
				if (min > scores[j])
					min = scores[j];
				sum += scores[j];
			}
			avg = sum / (double) scores.length;
			System.out.println(avg);

			System.out.println(names[i] + "의 평균점수 : " + avg + " 최소점수 : " + min + " 최대점수 " + max);
		}
	}
}
