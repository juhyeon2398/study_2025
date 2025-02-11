package org.joonzis.ex;

public class Ex06_Wrapper {
	public static void main(String[] args) {
		Integer a = new Integer(10);
		Integer b = new Integer(20);

		// 동등 비교
		System.out.println("저장된 위치 비교 :" + (a == b));
		System.out.println("저장된 내용 비교 :" + (a.equals(b)));

		// 크기 비교
		// a.compareTo(b) : 결과는 a-b를 통해서 계산
		// a.compareTo(b) : a > b 결과 1(양수)
		// a.compareTo(b) : a < b 결과 -1(음수)
		// a.compareTo(b) : a == b 결과 0

		// AutoBoxing, AutoUnBoxing
		// 값 -> 객체로 변환 : Boxing
		// 객체 -> 값으로 변환 : UnBoxing

		// AutoBoxing
		Integer c = 100;
		Integer d = 100;
		
		// AutoUnBoxing
		int result = c + d;
		System.out.println(result);
	}
}
