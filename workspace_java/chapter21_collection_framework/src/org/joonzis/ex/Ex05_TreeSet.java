package org.joonzis.ex;

import java.util.TreeSet;

public class Ex05_TreeSet {
	public static void main(String[] args) {
		TreeSet<String> set = new TreeSet<String>();
		
		set.add("airplane");
		set.add("apple");
		set.add("area");
		set.add("disc");
		set.add("dance");
		
		// headSet - 지정된 객체보다 작은 값의 객체 반환
		// subSet  - 범위 내의 검색 결과 반환
		// tailSet - 지정된 객체보다 큰 값의 객체들을 반환
		System.out.println(set.headSet("b"));
		System.out.println(set.subSet("a", "aq"));
		System.out.println(set.tailSet("c"));
	}
}

