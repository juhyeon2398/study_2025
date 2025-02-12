package org.joonzis.test;

// Q1. Test01.java
// 문자열/정수/실수 타입의 배열을 전달하고 데이터 타입을 체크하여
// 해당 데이터 타입과 해당 배열의 데이터들을 출력
// class TypeCheckClass - 필드 : T[] arr
//   					  메소드 : String checkType(T[] arr)
//   					  -> 타입에 따라서 "문자형 입니다.", "정수형 입니다" 등등 리턴
class TypeCheckClass<T> {
	private T[] arr;

	public String checkType(T[] arr) {
		this.arr = arr;
		if(arr.toString() instanceof String) {
			System.out.println("aaaaa");
		}
		return "";
	}
}
public class Test01 {
	public static void main(String[] args) {
		TypeCheckClass<String> chk= new TypeCheckClass<>();
		chk.checkType(new String[3]);
	}
}
