package com.singelton;

import java.io.Serializable;
import java.util.HashSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Singleton {	
	public static void main(String arg[]){
		HashSet<SinletonClass> set = new HashSet<SinletonClass>();
		CountDownLatch latch = new CountDownLatch(10000);
		Runnable thread = new Runnable() {
			
			@Override
			public void run() {
				set.add(SinletonClass.getInstance());
				//System.out.println("getting");
				latch.countDown();
			}
		};
		ExecutorService serv = Executors.newFixedThreadPool(10000);
		for(int i=0;i<10000;i++){
			serv.submit(thread);
		}
		
		try {
			while(latch.getCount()>0){
				System.out.println("count : "+latch.getCount());
			}
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("------------------------"+set.size());
				
		
		
	}
}

final class SinletonClass implements Serializable{
	private static final long serialVersionUID = -5160756474750768658L;
	private String value;
	private static volatile SinletonClass obj;	
	private  SinletonClass(){		
		value = "test";
	}		
	public static  SinletonClass getInstance(){		
		if(obj == null){
				obj = new SinletonClass();			
		}							
		return obj;
	}	
	protected Object readResolve(){
		System.out.println("read resolve");
		return obj;
	}
}