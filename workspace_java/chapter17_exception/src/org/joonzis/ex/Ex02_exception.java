package org.joonzis.ex;

// ArrayIndexOutOfBoundsException
// 배열에서 인덱스 범위를 초과하는 경우 예외 발생
// 정수를 0으로 나눌경우 발생

public class Ex02_exception {
	public static void main(String[] args) {

//		크기 3짜리 정수형 배열 arr를 선언
//		각 인덱스에 순서대로 1,2,3 삽입
//		항상 for 문을 이용하여 배열 내 데이터 출력
//		
//		예외 처리
//		위 실행 결과 확인 후 
//		강제로 arr[3]위치에 데이터 삽입
//		에러 발생 시 "인덱스 가용 범위를 벗어났습니다." 

		int[] arr;

		try {
			arr = new int[3];
			arr[0] = 5;
			arr[1] = 15;
			arr[2] = 35;
			for (int i : arr) {
				System.out.println(i);
			}
			arr[3] = 50;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 가용범위를 벗어났습니다.");
			e.printStackTrace();
		}
	}
}
