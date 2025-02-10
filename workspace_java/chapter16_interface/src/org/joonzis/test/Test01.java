package org.joonzis.test;
//Q1. Test01.java

//스마트폰 => 전화기 + 컴퓨터 
//
//class Phone 				필드 : String owner
//							메소드 : Constructor, sendCall(), receiveCall()
//interface Computable		메소드 : connectInternet(), playApp()
//class SmartPhone 			Phone 상속, Computable 구현
interface Computable {
	public void connectInternet();
	public void playApp();
}

class Phone {
	private String owner;

	public Phone() {
	}

	public Phone(String owner) {
		this.setOwner(owner);
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	void sendCall() {
		System.out.println("전화하는중");
	}

	void receiveCall() {	
		System.out.println("전화오는중");
	}
}

class SmartPhone extends Phone implements Computable {
	public SmartPhone() {
	}

	public SmartPhone(String owner) {
		super(owner);
	}

	@Override
	public void connectInternet() {
		System.out.println("인터넷 연결");
	}

	@Override
	public void playApp() {
		System.out.println("앱 실행");
	}

}

public class Test01 {
	public static void main(String[] args) {
		SmartPhone smartPh = new SmartPhone("김씨");
		smartPh.playApp();
		smartPh.connectInternet();
		smartPh.sendCall();
		smartPh.receiveCall();
	}
}
