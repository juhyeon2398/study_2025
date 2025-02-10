package org.joonzis.test;

public class Test02 {
	public static void main(String[] args) {
		Customer cus = new Customer(5000);
		
		cus.buy(new Tv("삼성 TV", 200));
		cus.buy(new Computer("삼성 컴퓨터", 300));
		
		cus.output();
 	}
}
