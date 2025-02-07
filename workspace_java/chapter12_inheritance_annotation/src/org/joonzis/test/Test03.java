package org.joonzis.test;

//Q3. Test03.java 상속 관계로 구현하시오.
//SalaryWorker.java			
//- 필드 : String name, String dept, int salary
//- 메소드 : Constructor, int pay(), output()	
//SalesWorker.java			
//- 필드 : String name, String dept, int salary , double salesIncentive
//- 메소드 : Constructor, int pay(), output(), int salesPay() : 수당 = 기본급 * 판매인센티브
//PartTimeWorker.java			
//- 필드 : String name, String dept, int workTime, int payPerHour
//- 메소드 : Constructor, int pay(), output()
//→ 부모클래스는 알아서 만들어보자!(Employee)
//SalaryWorker extends Employee
//SalesWorker extends SalaryWorker
//PartTimeWorker extends Employee
//	
//String name : 이름
//String dept : 부서
//int salary : 기본급(월급)
//double salesIncentive : 판매 인센티브
//int workTime : 근무시간
//int payPerHour : 시급

public class Test03 {
	public static void main(String[] args) {
		SalaryWorker salaryW = new SalaryWorker("김씨", "인사", 600);
		SalesWorker salesW = new SalesWorker("이씨", "홍보", 500, 0.2);
		PartTimeWorker partW = new PartTimeWorker("박씨", "개발", 6, 14200);
		
		salaryW.output();
		System.out.println("===============");
		salesW.output();
		System.out.println("===============");
		partW.output();
		
	}
}
