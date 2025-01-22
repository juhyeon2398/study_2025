package org.joonzis.ex;

public class Ex05_casting {
	public static void main(String[] args) {
		// 1. 자동 형 변환
		System.out.println(1+1.5);
		//java 스스로 1.0 + 1.5 변환 후 연산
		
		double a = 10;
		System.out.println(a);
		//java 스스로 a = 10.0 변환 후 연산
		
		
		//2. 강제 형 변환
		int b = (int)20.9;
		System.out.println(b);
		
		int c = 1;
		int d = 2;
		double e = (double)c/d;
		System.out.println(e);
		System.out.print("\n");
		
		//국, 영 , 수 3 과목의 평균을 화면에 출력
		//국어 (kor)
		//영어 (eng)
		//수학 (mat)
		//평균 (result)
		//점수 각각 70, 42, 96으로 초기화
		int kor = 70;
		int eng = 42;
		int mat = 96;
		double result = 0;
		result = (double)(kor + eng + mat)/3;		
		System.out.println("평균 : "+result);
		
	}
}
