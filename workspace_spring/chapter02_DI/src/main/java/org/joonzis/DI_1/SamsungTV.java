package org.joonzis.DI_1;

public class SamsungTV {
	public SamsungTV() {
		System.out.println("==> SamsungTV 객체 생성");
	}
	
	public void powerOn() {
		System.out.println("SamsungTV -- 전원 on");
	}
	public void powerOff() {
		System.out.println("SamsungTV -- 전원 off");
	}
	public void volumUp() {
		System.out.println("SamsungTV -- 소리 UP");
	}
	public void volumDown() {
		System.out.println("SamsungTV -- 소리 DOWN");
	}
}
