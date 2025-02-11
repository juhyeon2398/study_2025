package org.joonzis.test;

import java.util.Scanner;

//Q3. Test03.java									   
//주민등록 번호 (하이픈 포함)를 입력 받아 출력하시오.
//주민등록번호가 14글자가 아니면 PerIDException 클래스를 이용하여 예외를 처리하시오.
//주민등록번호를 입력받기 위해 String getPerID() 메소드를 이용하시오.		



class PerIDException extends Exception{
	private static final long serialVersionUID = 1L;
	
	private int errCode;

	public PerIDException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}
	
	public int getErrCode() {
		return errCode;
	}
}

public class Test03 {
	static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		try {
			String num = getPerID();
			System.out.println(num);
		} catch (PerIDException e) {
			// TODO: handle exception
		}
		
	}
	static String getPerID() throws PerIDException {
		System.out.println("주민등록 번호 (하이픈 포함)");
		String perId= sc.next();
		if(perId.length() != 14) {
			throw new PerIDException("", 11000);
		}
		
		return "";
	}
}
