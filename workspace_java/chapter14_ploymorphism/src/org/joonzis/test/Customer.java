package org.joonzis.test;

public class Customer {
	private int money, startMoney, numOfProduct;
	private Product[] cart = new Product[10];

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getStartMoney() {
		return startMoney;
	}

	public void setStartMoney(int startMoney) {
		this.startMoney = startMoney;
	}

	public Product[] getCart() {
		return cart;
	}

	public void setCart(Product[] cart) {
		this.cart = cart;
	}

	public Customer(int startMoney) {
		setStartMoney(startMoney);
		setMoney(startMoney);
	}

	// 상품 구매(소지 금액보다 구매 금액이 큰 경우 예외처리)/구매한 만큼 금액 차감/카트에 상품 추가
	public void buy(Product pro) {
		if(money < pro.getPrice()) {
			System.out.println("잔액 부족");
			return;
		}
		money -= pro.getPrice();
		cart[numOfProduct] = pro;
		numOfProduct++;
	}

	public void output() {
		int total = 0;
		for (int i = 0; i < numOfProduct; i++) {
			System.out.println(cart[i].getModel()+", "+ cart[i].getPrice());
			total += cart[i].getPrice();
		}
		
		System.out.println(startMoney);
		System.out.println(money);
	}

}
