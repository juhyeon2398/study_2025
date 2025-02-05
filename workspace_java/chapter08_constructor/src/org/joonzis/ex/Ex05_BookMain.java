package org.joonzis.ex;

//필드
//String title : 책 제목
//String writer :  저자
//int price : 가격
//int salesVolume : 판매량
//boolean isBestSeller : 베스트 셀러 유무

//메소드
//생성자()
//생성자() : 제목, 가격 초기화 (저자는 "작자미상")
//생성자() : 제목, 가격 저자 초기화
//setSalesVolume(int sales) : 판매량을 입력 받아 판매량이 1000이상이면 베스트 셀러
//output(): 제목, 저자, 가격, 판매량, 베스트셀러 유무 출력

public class Ex05_BookMain {
	public static void main(String[] args) {
		Ex05_Book book = new Ex05_Book("수학의 정석", 30000);
		book.setSalesVolume(10001);
		book.output();

		System.out.println("========================");

		Ex05_Book book2 = new Ex05_Book("자바 기초", 52000, "홍길동");
		book2.setSalesVolume(901);
		book2.output();

	}
}
