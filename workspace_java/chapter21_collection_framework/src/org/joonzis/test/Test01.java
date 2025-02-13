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
	String title, content;
//	Date register;
	
	public Board(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "제목 : " +title + ", 내용 : " + content;
	}
}

public class Test01 {
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		Board borad = new Board("제목1","내용1");
		Board borad2 = new Board("제목2","내용2");
		Board borad3 = new Board("제목3","내용3");
		arr.add(borad.toString());
		arr.add(borad2.toString());
		arr.add(borad3.toString());
		
		System.out.println(arr);
		
		arr.remove(1);
		System.out.println(arr);
	}
}
