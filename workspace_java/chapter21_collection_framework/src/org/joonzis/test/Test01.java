package org.joonzis.test;

import java.util.ArrayList;
import java.util.Date;

//Q1. Test01.java
//
//게시물을 저장하는 Board 클래스를 정의하고, ArrayList를 이용하여 3개의 게시물을 저장하시오.
//1~3번 게시물번호 중 하나를 입력 받아 해당 게시물을 삭제하시오.
//
//class Board			필드 : String title, String content, Date register
//							register -> 현재 날짜 자동 삽입
//					메소드 : 생성자, toString()

class Board{
	private String title, content;
	private Date register;
	
	public Board(String title, String content) {
		this.title = title;
		this.content = content;
		this.register = new Date();
	}
	
	@Override
	public String toString() {
		return "제목 : " +title + ", 내용 : " + content;
	}
}

public class Test01 {
	public static void main(String[] args) {
		ArrayList<Board> arr = new ArrayList<Board>();
		arr.add(new Board("11","55"));
		arr.add(new Board("22","66"));
		arr.add(new Board("33","77"));
		
		arr.remove(1);
		System.out.println(arr);
	}
}
