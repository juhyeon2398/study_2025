package org.joonzis.ex;

public class Ex03_Team {
	String name;
	static int count = 0; // 공유 자원
	
	public Ex03_Team(String name) {
		this.name = name;
		count++;
	}
	
	void output() {
		System.out.println("이름 : " + name);
		System.out.println("현재 팀원 : " + count+"명");
	}
}
