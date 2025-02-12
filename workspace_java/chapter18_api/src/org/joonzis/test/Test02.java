package org.joonzis.test;

//Q2. Test02.java
//User 클래스 					
//필드 : String id, password
//메소드 : Constructor, toString(), equals()
//User 인스턴스를 2개 생성하고, 동등 비교(id, password 모두 같으면 동등) 결과 출력
//각 인스턴스 정보는 toString 메소드를 통해 출력
class User {
	private String id, password;

	public User() {
	}

	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}

	@Override
	public String toString() {
		return "아이디 : " + id + " 비밀번호 : " + password;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof User) {
			User another = (User) obj;
			return (this.id).equals(another.id) && (this.password).equals(another.password);
		} else {
			return false;
		}
	}
}

public class Test02 {
	public static void main(String[] args) {
		User user = new User("wi", "1234");
		User user2 = new User("wi", "1234");
		User user3 = new User("wii", "1234");

		if (user.toString().equals(user2.toString())) {
			System.out.println("같다.");
		} else {
			System.out.println("다르다.");
		}

		System.out.println(user.equals(user3) ? "같다." : "다르다.");
	}
}
