package org.joonzis.test;


//Q2. Test02.java
//
//정수/실수 타입의 배열을 전달하면 해당 배열에 저장된 모든 요소의 합을 리턴하는 sum() 메소드를 구현하시오.
//예) int 5개 전달하면 5개의 합 출력
//★
// - static <T extends Number> double sum(T[] arr)  형식 작성
// 	-> Number 형태의 데이터만 가능하다는 의미(int, long, float, double, byte, short)
// - 배열의 값을 가져올때 배열.doubleValue()사용
// 	-> 배열인덱스.doubleValue()


public class Test02 {
	static <T extends Number> double sum(T[] arr) {
		double sumNum = 0;
		for (int i = 0; i < arr.length; i++) {
			sumNum += arr[i].doubleValue();
		}
		return sumNum;
	}
	
	public static void main(String[] args) {
		Integer[] arr = {1,2,3,4,5,6,7,8,9,10};
		System.out.println((int) sum(arr));
	}
}
