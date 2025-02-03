package org.joonzis.ex;

public class Ex01_BookMain {
	public static void main(String[] args) {
		
		// 1. Book 객체(인스턴스) 생성
		Ex01_Book myBook = new Ex01_Book();
		myBook.title = "자바의 정석";
		myBook.writer = "홍길동";
		myBook.price = 35000;
		myBook.isBestSeller = true;
		
		myBook.info();
		
		
	}
}
