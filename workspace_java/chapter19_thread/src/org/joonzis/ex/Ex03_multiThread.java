package org.joonzis.ex;

class MyThrea2 implements Runnable{
	private String str;

	public MyThrea2(String str) {
		this.str = str;
	} 
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);
				System.out.println(str);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

public class Ex03_multiThread {
	public static void main(String[] args) {
	
		System.out.println("Main Thread Start");
		
		MyThrea2 mt1 = new MyThrea2("*");
		MyThrea2 mt2 = new MyThrea2("-");
		Thread t1 = new Thread(mt1);
		Thread t2 = new Thread(mt2);
		
		t1.start();
		t2.start();
		
		System.out.println("Main Thread end");
	}
}
