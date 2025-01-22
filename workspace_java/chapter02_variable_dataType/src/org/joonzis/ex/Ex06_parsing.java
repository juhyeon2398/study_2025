package org.joonzis.ex;

public class Ex06_parsing {
	public static void main(String[] args) {
		String strAge = "20";
		String strHeight = "180.5";

		int age = Integer.parseInt(strAge);
		double height = Double.parseDouble(strHeight);
		System.out.println("나이 : " + (age + 1) + "\n" + "키 : " + height + "cm");

		// 문자열 비교는 "=="로 진행하지 않는다.
		// equals() 메소드를 이용한다.

		String s1 = "aaa";
		String s2 = s1;
		String s3 = new String("aaa");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		if (s1 == s2) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		if (s1.equals(s3)) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		
		// == 연산자의 경우 객체의 주소 값을 비교
		// .equals() 메소드의 경우 대상의 값을 비교
		// CBV(Call By Value) - 원시 데이터 타입( 주소 값 X )
		// CBR(Call By Reference) - 참조 객체( 클래스 등 )
	}
}
