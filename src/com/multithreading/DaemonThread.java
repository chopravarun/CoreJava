package com.multithreading;

/**
 * 1. normal thread can run even if main thread already finished, Daemon thread can not run 
 * if main thread has died.
 * 
 * @author choprava
 *
 */
public class DaemonThread {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Daemon());
		
		
		
		t.setDaemon(true);
		t.start();
		System.out.println("main thread sleeping");
		Thread.sleep(500);
		System.out.println("main thread finished");			
	}
}

class Daemon implements Runnable{

	@Override
	public void run() {
		try{
			while(true){
				System.out.println("this is daemon thread");
				Thread.sleep(500);
			}
		}catch(Exception e){
			System.out.println("exp occured");
		}
	}
	
}
