package org.joonzis.ex;

public class Ex01_if {
	public static void main(String[] args) {
		int num = 20;

		// 변수의 값이 양수인지, 음수인지 인지 판단
		if (num > 0) {
			System.out.println("num값은 양수 입니다.");
		} else if (num < 0) {
			System.out.println("num값은 음수 입니다.");
		} else {
			System.out.println("num값은 0 입니다.");
		}
		
		double avg = 92.3;//평균
		//평균 점수가 90이상이면 A
		//평균 점수가 80이상이면 B
		//평균 점수가 70이상이면 C
		//평균 점수가 60이상이면 D
		//평균 점수가 60미만이면 F
		
		if(avg >= 90) {
			System.out.println("A");
		}else if(avg >= 80) {
			System.out.println("B");
		}else if(avg >= 70) {
			System.out.println("C");
		}else if(avg >= 60) {
			System.out.println("D");
		}else {
			System.out.println("F");
		}
	}
}
