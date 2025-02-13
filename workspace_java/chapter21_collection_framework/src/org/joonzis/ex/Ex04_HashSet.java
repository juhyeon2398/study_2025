package org.joonzis.ex;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex04_HashSet {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("C");
		set.add("Spring");
		set.add("java");
		set.add("DB");
		set.add("JSP");
		set.add("Web");
		set.add("java");
		
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()) {
			String str = itr.next();
			if(str.equals("Spring")) {
				itr.remove();
			}
		}
		
//		set.remove("Spring"); // set 특정 객체 삭제
//		set.removeAll(set);   // set 전체 객체 삭제
		System.out.println(set);
		
	}
}

