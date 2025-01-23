package org.joonzis.ex;

public class Ex02_switch {
	public static void main(String[] args) {
		String gender = "여";
		if (gender.equals("남")) {
			System.out.println("남자입니다.");
		} else {
			System.out.println("여자입니다.");
		}

		switch (gender) {
		case "남":
			System.out.println("남자입니다.");
			break;
		default:
			System.out.println("여자입니다.");
			break;
		}
	}
}
