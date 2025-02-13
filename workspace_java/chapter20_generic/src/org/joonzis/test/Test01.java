package org.joonzis.test;

import java.util.Arrays;

// Q1. Test01.java
// 문자열/정수/실수 타입의 배열을 전달하고 데이터 타입을 체크하여
// 해당 데이터 타입과 해당 배열의 데이터들을 출력
// class TypeCheckClass - 필드 : T[] arr
//   					  메소드 : String checkType(T[] arr)
//   					  -> 타입에 따라서 "문자형 입니다.", "정수형 입니다" 등등 리턴
class TypeCheckClass<T> {
	private T[] arr;

//	@SuppressWarnings("unchecked")
//	public TypeCheckClass(int idx) {
//		this.arr = (T[]) (new Object[idx]);
//	}

	public String checkType(T[] arr) {
//		String inputType = arr.getClass().getName();
//		if (inputType.contains("String")) {
//			return "문자형 입니다.";
//		} else if (inputType.contains("Integer")) {
//			return "정수형 입니다.";
//		} else {
//			return "실수형 입니다.";
//		}
		
		this.arr = arr;
		if(arr instanceof String[]) {
			return "문자형 입니다.";
		}else if(arr instanceof Integer[]){
			return "정수형 입니다.";
		}else {
			return "실수형 입니다.";
		}
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("배열데이터 : " + Arrays.toString(arr)).append(checkType(arr));
		return sb.toString();
	}

}

public class Test01 {
	public static void main(String[] args) {
		Double[] arr = { 1.1, 2.1, 3.9, 4.2, 5.5 };
		String[] arrStu = { "111", "222", "333", "444", "555" };

		TypeCheckClass<Double> chk = new TypeCheckClass<>();
		System.out.println(chk.checkType(arr));

		TypeCheckClass<String> chk2 = new TypeCheckClass<>();
		System.out.println(chk2.checkType(arrStu));
	}
}
