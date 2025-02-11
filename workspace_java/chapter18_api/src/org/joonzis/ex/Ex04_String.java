package org.joonzis.ex;

public class Ex04_String {
	public static void main(String[] args) {
		// 인스턴스는 다르지만 내부 데이터가 동일하므로 객체 1개만 저장
		
		String a ="apple";
		String b ="apple";
		
		System.out.println(a == b ? "사과 1개" : "사과 2개");
		String c= new String("banana");
		String d = new String("banana");
		System.out.println(c == d ? "사과 1개" : "사과 2개");
		
		String sn = "000000-1234567";
		String[] snArr =sn.split("-");
		for (String s : snArr) {
			System.out.println(s);
		}
		
		String today = "1980.10.21";
		String[] ymd = today.split("\\.");
		// 몇몇 특수문자는 사용시 앞에 역슬래시2개(\\)를 붙여줘야함
		// | ? * () {} [] \
		for (String s : ymd) {
			System.out.println(s);
		}
		
		//.join()
		String today2 = String.join("-", ymd);
		System.out.println(today2);
		
		//.valueOf
		// 정수 -> 문자열 : String.valueOf(10) ++ "10"
		// 실수 -> 문자열 : String.valueOf(1.5) ++ "1.5"
		
		//.subString()
		//.subString(시작인덱스) : 시작인덱스 부터 끝까지 출력
		//.subString(시작인덱스, 종료인덱스) : 시작인덱스 부터 종료인덱스까지 출력
		
		String phone = "010-1234-5678";
		
		String p1 =phone.substring(0,3);
		String p2 =phone.substring(4,8);
		String p3 =phone.substring(9);
		
	}
}
