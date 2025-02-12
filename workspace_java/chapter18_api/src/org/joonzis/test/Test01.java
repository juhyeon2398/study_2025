package org.joonzis.test;

// Q1. Test01.java
// Score 클래스 					
// 필드 : int kor, eng, mat
// 메소드 : Constructor, toString(), equals()
// Score 인스턴스를 2개 생성하고, 동등 비교(세과목이 모두 같으면 동등) 결과 출력
// 각 인스턴스 정보는 toString 메소드를 통해 출력

class Score {
	private int kor, eng, mat;

	public Score() {
		// TODO Auto-generated constructor stub
	}

	public Score(int kor, int eng, int mat) {
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	@Override
	public String toString() {
		return "국어 : " + kor + " 영어 : " + eng + " 수학 : " + mat;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Score) {
			Score another = (Score) obj;
			return this.kor == another.kor && this.eng == another.eng && this.mat == another.mat;
		} else {
			return false;
		}
	}

}

public class Test01 {
	public static void main(String[] args) {
		Score s = new Score(10, 20, 30);
		Score s2 = new Score(10, 20, 30);

		if (s.toString() == s2.toString()) {
			System.out.println("같다.");
		} else {
			System.out.println("다르다.");
		}

		System.out.println(s.equals(s2) ? "같다" : "다르다");

	}
}
