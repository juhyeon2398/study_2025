package org.joonzis.ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex01_ArrayList {
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(new Integer(1));
		list.add(new Integer(2));
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(5,2);
		
		System.out.println(list);
		// .add(인덱스, 값)
		
		// 2. 저장됨 요소 가져오기 get(idx)
		// size() = length()
		
		for (int i = 0; i < list.size() ; i++) {
			System.out.println(list.get(i));
		}
		list.remove(0); // 인덱스 객체 삭제
		list.clear(); // 저장된 모든 객체 삭제
		System.out.println(list);
		
		
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(5);
		list2.add(6);
		list2.add(7);
		for (int i = 0; i < list.size(); i++) {
			if(list.contains(list2.get(i))) {
				System.out.println("중복 값 : " + list.get(i));
			}
		}
		System.out.println(list);
		
		// 정렬 : sort(list)
		Collections.sort(list);
		System.out.println("정렬 후 List : " + list);
		
		// 최악의 성능으로 모든 데이터 삭제
		while(list.size() > 0) {
			list.remove(0);
		}
	}
	
}
