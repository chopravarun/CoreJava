package com.multithreading;

public class ThreadClone {
	public static void main(String[] args) throws CloneNotSupportedException {
		ThreadCloneTask t1 = new ThreadCloneTask();		
		ThreadCloneTask t2 = (ThreadCloneTask) t1.clone();	
		
		Thread t = new Thread(t1);
		Thread tt = new Thread(t2);
		t.start();
		tt.start();
	}	
}

class ThreadCloneTask implements Cloneable,Runnable{
	@Override
	public Object clone() throws CloneNotSupportedException{		
		return super.clone();
	}

	@Override
	public void run() {
		for(int i=0;i<150;i++)
		System.out.println(Thread.currentThread().getName());
	}

}
