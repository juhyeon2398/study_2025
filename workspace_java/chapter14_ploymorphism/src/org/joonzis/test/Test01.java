package org.joonzis.test;

public class Test01 {
	public static void main(String[] args) {
		Employee[] em = new Employee[3];
		
		em[0] = new SalaryWorker("홍길동", "인사" , 300);
		em[1] = new SalesWorker("김철수" , "개발" , 200, 1500);
		em[2] = new PartTimeWorker("김영희", "홍보", 6, 6000);
		
		for (int i = 0; i < em.length; i++) {
			em[i].output();
			System.out.println("=================");
		}
		
	}
}
