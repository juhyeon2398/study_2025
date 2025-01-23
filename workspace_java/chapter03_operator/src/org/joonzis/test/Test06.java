package org.joonzis.test;

import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
//		Q. 체질량 지수(BMI) = 몸무게(kg) / 키 (m) 제곱 
//		BMI 25 이상이면 "과체중", 20 이상이면 "정상", 20 미만이면 "저체중"
		Scanner sc = new Scanner(System.in);

		double height = 0;
		double weight = 0;

		System.out.println("몸무게(kg)를 입력해주세요 : ");
		weight = sc.nextDouble();
		System.out.println("키(m)를 입력해주세요 : ");
		height = sc.nextDouble();

		double bmi = weight / (height * height);
		String result = (bmi >= 25) ? "과체중" : (bmi < 25 && bmi >= 20) ? "정상" : "저체중";
		System.out.println("당신의 BMI 수치는 : " + bmi + "이므로 " + result);

	}
}
