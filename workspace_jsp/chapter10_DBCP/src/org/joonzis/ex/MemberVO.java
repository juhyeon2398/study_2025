package org.joonzis.ex;

import java.sql.Date; // DB 날짜

public class MemberVO {
	private int idx;
	private String id;
	private String pw;
	private String name;
	private int age;
	private String addr;
	private Date regdate;
	
	public MemberVO() {}
	 
	public MemberVO(int idx, String id, String pw, String name, int age, String addr, Date regdate) {
		this.idx = idx;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.addr = addr;
		this.regdate = regdate;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
}
