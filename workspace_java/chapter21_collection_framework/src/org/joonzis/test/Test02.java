package org.joonzis.test;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Random;
import java.util.Scanner;


//Q2. Test02.java
//로또 & 빙고 (빙고가 어려우면 로또부터 해보기)
//Set을 이용하여 5 X 5 Bingo 배열을 생성하시오. (1 ~ 25)
//Set에 랜덤 생성 -> Bingo 2차원 배열에 저장 

public class Test02 {
	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<String>();
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		String answer;
		int bingo = 0;
		int sam = 0;
		int num;
		while (true) {
			num = ran.nextInt(25) + 1;
			if (!set.contains(num)) {
				set.add(Integer.toString(num));
			}
			if (set.size() == 25) {
				break;
			}
		}

		String[][] arr = new String[5][5];
		Iterator<String> itr = set.iterator();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = itr.next();
			}
		}

		itr = set.iterator();
		int idx = 1;
		while (itr.hasNext()) {
			System.out.print(itr.next() + "\t");

			if (idx % 5 == 0 && idx != 0) {
				System.out.print("\n");
			}

			idx++;
		}

		System.out.println("=========================================");

		while (true) {
			System.out.print("빙고 입력 (종료 -> 그만) >> ");
			answer = sc.next();

			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if (arr[i][j].equals(answer)) {
						arr[i][j] = "*";
					}

					if (arr[i][j].equals("*")) {
						sam++;
						System.out.println("aaaaa");
					}

					System.out.print(arr[i][j] + "\t");
				}
				System.out.println();
			}
			
			System.out.println("=========================================");
			if (sam == 5) {
				bingo++;
				System.out.println(bingo + " 빙고");
				sam = 0;
			}

			if (answer.equals("그만")) {
				System.out.println("빙고 종료");
				break;
			}
		}
	}
}
