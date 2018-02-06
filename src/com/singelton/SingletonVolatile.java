package com.singelton;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonVolatile {
	public static void main(String[] args) throws InterruptedException {
		final Set<SingleVolatile> setOfSingleton = new HashSet<>();
		int numberOfThreads = 1000;
		final CountDownLatch latch = new CountDownLatch(numberOfThreads);
		ExecutorService exe = Executors.newFixedThreadPool(numberOfThreads);
		
		for(int i=0;i<numberOfThreads;i++){
			
			Runnable runit = new Runnable() {						
				@Override
				public void run() {
					setOfSingleton.add(SingleVolatile.getInstance());
					latch.countDown();
				}
			};
			
			exe.submit(runit);
		}
		
		System.out.println("threads submitted waiting for threads to complete");
		latch.await();
		System.out.println("active thread count : "+ latch.getCount());
		exe.shutdown();	
		System.out.println("Total objects created : "+ setOfSingleton.size());
		
	}
}

class SingleVolatile{
	
	private static volatile SingleVolatile obj;
	private SingleVolatile(){}
	
	public static SingleVolatile getInstance(){			
		if(SingleVolatile.obj == null){
			SingleVolatile.obj = new SingleVolatile();
		}		
		return SingleVolatile.obj;
	}
	
}
