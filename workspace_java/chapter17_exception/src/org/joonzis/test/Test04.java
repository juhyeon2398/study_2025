package org.joonzis.test;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

//Q4. Test04.java		
//Up-Down 게임
//1 ~ 100 사이의 난수를 발생시켜 해당 값을 맞출때까지 게임을 진행하시오.
//다음의 경우 예외를 발생시키시오.
//1) 사용자가 1 ~ 100 이외의 값을 입력한 경우 NumberOutOfBoundsException 클래스를 이용하여 예외 처리
//2) 정수대신 다른 데이터 (예: 실수, 문자) 등을 입력한 경우

class UpDown {
	private int resultNum, input;

	public UpDown(int resultNum) {
		this.resultNum = resultNum;
		System.out.println("설정된 값 : " + resultNum);
	}

	public void matchNum(int num) throws NumberOutOfBoundsException, InputMismatchException {
		if (num < 1 && num > 100) {
			throw new NumberOutOfBoundsException("1~100 사이 숫자를 넣어주세요.", 1000);
		}
		this.input = num;
	}

	public int getResult() {
		return resultNum;
	}

	public int getInput() {
		return input;
	}

}

class NumberOutOfBoundsException extends Exception {
	private static final long serialVersionUID = 1L;

	int errCode;

	public NumberOutOfBoundsException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}

	public int getErrCode() {
		return errCode;
	}

}

public class Test04 {
	public static void main(String[] args) {
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);

		UpDown ud = new UpDown(ran.nextInt(100) + 1);

		try {
			while (true) {
				System.out.print("정답을 입력하세요 >> ");
				ud.matchNum(sc.nextInt());
				if (ud.getResult() == ud.getInput()) {
					System.out.println("정답");
					break;
				} else if (ud.getResult() > ud.getInput()) {
					System.out.println("UP");
				} else {
					System.out.println("Down");
				}
			}

		} catch (NumberOutOfBoundsException e) {
			System.out.println(e.getMessage() + e.getErrCode());
		} catch (InputMismatchException e) {
			System.out.println("정수형태로 입력해주세요.");
		}

	}
}
