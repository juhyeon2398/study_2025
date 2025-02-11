package org.joonzis.ex;

// DepositException 	: 마이너스 입금 처리, 예외 코드 1000
// WithdrawException 	: 잔액 초과 출금 처리, 예외 코드 2000
//						: 마이너스 출금 처리, 예외 코드 2001
class BankAccount {
	// 필드
	private String no; // 계좌 번호
	private long balance; // 계좌 잔액

	public BankAccount(String no, long balance) {
		this.no = no;
		this.balance = balance;
	}

	// 입금
	public void deposit(long money) throws DepositException {
		if (money < 0) {
			throw new DepositException("0보다 작으면 입금 불가", 1000);
		}
		balance += money;
	}

	// 출금
	public void withdraw(long money) throws WithdrawException {
		balance -= money;
		if(money < 0) {
			throw new WithdrawException("0보다 작으면 출금 불가", 2001);
		}
		if(balance < money) {
			throw new WithdrawException("잔액이 부족합니다.", 2000);
		}
	}

	// 조회
	public void inquire() {
		System.out.println("계좌 번호 : " + no);
		System.out.println("계좌 잔액 : " + balance);
	}

	// 이체
	public void transfer(BankAccount account, long money) throws DepositException, WithdrawException {
		withdraw(money);
		account.deposit(money);
	}
}

class DepositException extends Exception {
	private static final long serialVersionUID = 1L;
	private int errCode;

	public DepositException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}

	public int getErrCode() {
		return errCode;
	}
}

class WithdrawException extends Exception {
	private static final long serialVersionUID = 1L;
	private int errCode;

	public WithdrawException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}

	public int getErrCode() {
		return errCode;
	}
}

public class Ex08_exception {
	public static void main(String[] args) {

		BankAccount parent = new BankAccount("123-456", 10000);
		BankAccount child = new BankAccount("789-012", 0);

		try {
			// 1. 부모 계좌에 10,000원 입금
			parent.deposit(10000);
			parent.inquire();
			System.out.println("===================");
			// 2. 부모 계좌에서 5,000원 출금 - 출금 예외
			parent.withdraw(5000);
			parent.inquire();
			System.out.println("========= 전 =========");
			parent.inquire();
			child.inquire();
			System.out.println("========= 후 =========");
			parent.transfer(child, 3000);
			parent.inquire();
			child.inquire();
			// 3. 부모 계좌에서 자식 계좌로 3,000원 이체
			// - 입금, 출금 예외
		} catch (WithdrawException e) {
			System.out.println("에러 메세지 : " + e.getMessage() + "코드 : " + e.getErrCode());
		} catch (DepositException e) {
			System.out.println("에러 메세지 : " + e.getMessage() + "코드 : " + e.getErrCode());
		}

	}
}
