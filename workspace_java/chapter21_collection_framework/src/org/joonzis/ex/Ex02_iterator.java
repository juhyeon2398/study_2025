package org.joonzis.ex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex02_iterator {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++) {
			list.add(i*10);
		}
		System.out.println(list);
		
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	
}
