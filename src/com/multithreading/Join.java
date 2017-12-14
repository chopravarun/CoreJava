package com.multithreading;

public class Join {
	public static void main(String[] args) throws InterruptedException {
		
		Runnable task = new Runnable() {			
			@Override
			public void run() {
				for(int i=0;i<10;i++){
					System.out.println("I am in thread");
					Task tt = Task.currentThread();
					try {
						tt.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		};
		
		Task t = new Task(task);
		Task tt = Task.currentThread();
		t.start();
		t.join();
		System.out.println("i am in main");
		
	}
}

