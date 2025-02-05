package org.joonzis.ex;

public class Ex02_Local {
	String name;
	int age;
	String sn; // 주민등록 번호
	boolean isKorean;

	void setLocalInfo(String n, int a, String num) {
		name = n;
		age = a;
		sn = num;
		char gender = 0;
		if (num.indexOf('-') > 0) {
			gender = num.charAt(7);
		} else {
			gender = num.charAt(6);
		}
		isKorean = gender == '1' || gender == '2' || gender == '3' || gender == '4';
	}

	void setLocalInfo(String n, int a) {
		// 이름, 나이 전달받음
		name = n;
		age = a;
	}

	void output() {
		// 이름, 나이, 주민번호, 한국인 or 외국인 출력
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		if (sn == null) {
			System.out.println("없음");
		} else {
			System.out.println("주민등록번호 : " + sn);
			System.out.println(isKorean ? "한국인" : "외국인");
		}
	}
}
