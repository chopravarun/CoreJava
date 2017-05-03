package com.multithreading;

public class Join {
	public static void main(String[] args) throws InterruptedException {
		
		Runnable task = new Runnable() {			
			@Override
			public void run() {
				for(int i=0;i<10;i++){
					System.out.println("I am in thread");
					Thread tt = Thread.currentThread();
					try {
						tt.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		};
		
		Thread t = new Thread(task);
		Thread tt = Thread.currentThread();
		t.start();
		t.join();
		System.out.println("i am in main");
		
	}
}

