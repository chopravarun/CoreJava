package com.multithreading;

public class SyncAndNonSyncMethodAccess extends Task {
	String s = null;
	
	public static void main(String[] args) {
		LockObject obj = new LockObject();
		LockObject obj1 = new LockObject();
		
		
		String s = null;
		Task t1 = new Task(new ThreadOne(obj));
		Task t2 = new Task(new ThreadTwo(obj1));
		
		t1.start();		
		// clone a thread and try
		// other 
		
		
		t2.start();
		
	}
}
class LockObject{
	synchronized public void task() throws InterruptedException{
		for(int i=0;i<10000;i++){
			System.out.println(i+";");			
		}
	}

	synchronized public void justPrint() throws InterruptedException{
		for(int i=0;i<10000;i++){
			System.out.println(i+"#");			
		}		
	}
}

class ThreadTwo implements Runnable{
	LockObject obj;
	ThreadTwo(LockObject obj){
		this.obj = obj;
	}

	@Override
	public void run() {
		try {
			this.obj.justPrint();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class ThreadOne implements Runnable{

	LockObject obj;
	ThreadOne(LockObject obj){
		this.obj = obj;
	}
	
	@Override
	public void run() {		
		try {
			this.obj.task();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		System.out.println("task comlete");
	}
	
}
