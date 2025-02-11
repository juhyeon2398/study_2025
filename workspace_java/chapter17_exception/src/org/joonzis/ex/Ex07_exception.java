package org.joonzis.ex;

//예외 클래스 : Exception 을 상속 받아서 만든다
//예외 클래스를 만드는 이유: 사용자 친화적인 예외 처리를 위해
//예외가 아닌 것도 예외로 만들 수 있다.

class MyException extends Exception {
	private static final long serialVersionUID = 1L;

	public MyException(String msg) {
		super(msg);
	}
}

public class Ex07_exception {
	public static void main(String[] args) {
		try {
			throw new MyException("내가 만든 예외");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
