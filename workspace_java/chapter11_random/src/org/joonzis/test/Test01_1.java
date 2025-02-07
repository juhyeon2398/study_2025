package org.joonzis.test;

import java.util.Arrays;
import java.util.Random;

//Q1. Test01.java 랜덤을 이용하여 로또 만들기.
//- 임의의 값 6개(중복 제거), 
//입력받는 값 6개를 비교하여 맞는 개수와 해당 번호를 출력
//	* 로또 및 선택 번호는 1~45 사이의 값
//	
//	1. 임의의 값 6를 배열에 담는다(랜덤 이용)
//	2. 내가 선택한 값 6개를 배열에 담는다 (스캐너 이용)
//	3. 로또 번호 : 배열 내용 출력
//	4. 선택 번호 : 배열 내용 출력
//	5. 맞은 개수 : OO개
//	6. 맞은 번호 : 내용 나열 

public class Test01_1 {

	public static void main(String[] args) {

		Random ran = new Random();

		int[] arr = new int[6];
		int[] answer = { 42, 36, 20, 5, 1, 30 };

		for (int i = 0; i < arr.length; i++) {
			int ranNum = ran.nextInt(45) + 1; // 난수 발생

			// 중복여부 비교
			for (int j : arr) {
				if (j == ranNum) {
					System.out.println("난수 : " + Arrays.toString(arr));
					System.out.println("중복된 난수 : " + ranNum);
					System.out.println("중복으로 인한 재실행");
					System.out.println("==========================");

					// 난수 재설정;
					while (true) {
						int newNum = ran.nextInt(45) + 1; // 신규 난수
						if (ranNum != newNum) {
							ranNum = newNum;
							break; // 무한루프 종료
						}
					}
					break; // 중복비교 종료
				}
			}
			arr[i] = ranNum; // 값 저장
		}

		// 정답 비교
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < answer.length; j++) {
				if (arr[i] == answer[j]) {
					count++;
				}
			}
		}

		System.out.println("난수 : " + Arrays.toString(arr));
		System.out.println("제출 : " + Arrays.toString(answer));
		System.out.println("정답 갯수 : " + count);
	}
}
