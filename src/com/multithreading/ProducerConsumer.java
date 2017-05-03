package com.multithreading;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {
	public static void main(String[] args) {
		List<String> out = null;//new ArrayList<String>();
		Consumer con = new Consumer(out);
		Producer prod = new Producer(out);
		
		Thread consumerThread = new Thread(con);
		Thread producerThread = new Thread(prod);
		
		consumerThread.start();
		producerThread.start();
	}
}

class Consumer implements Runnable{
	List<String> outputList;
	
	public Consumer(List<String> outputList){
		this.outputList = outputList;
	}
	
	public void performTask() throws InterruptedException{
		synchronized (outputList) {
			while(outputList.size() == 0){
				outputList.wait();				
			}
			String str = outputList.remove(0);
			System.out.println("Consumed - "+str);
			outputList.notifyAll();
		}
	}

	@Override
	public void run() {
		try {
			for(int i=0;i<100;i++){			
				performTask();
			}
		} catch (InterruptedException e) {
			System.out.println("consumer error" + e);
		}
	}
}
class Producer implements Runnable{
	List<String> outputList;
	
	public Producer(List<String> outputList) {
		this.outputList = outputList;
	}
	
	public void performTask(int n) throws InterruptedException{
		synchronized (outputList) {
			while(outputList.size()==10){
				System.out.println("list full");
				outputList.wait();
			}
			
			System.out.println("producer -"+n);
			outputList.add(String.valueOf(n));
			outputList.notifyAll();
			//Thread.currentThread().sleep();
		}
	}

	@Override
	public void run() {
		try {
			for(int i=0;i<100;i++){			
				performTask(i);
			}
		} catch (InterruptedException e) {
			System.out.println("producer error : "+e);
		}
	}
}
