package com.multithreading;

public class MethodOverRiddingAndThreads {
	public static void main(String[] args) {
		Task1 one = new Task1(new Derive("$"));
		Task1 two = new Task1(new Derive("#"));
		
		Thread t1 = new Thread(one);
		Thread t2 = new Thread(one);
		
		t1.start();
		t2.start();
		
	}
}

class Task1 implements Runnable{

	Base obj;
	Task1(Base obj){
		this.obj = obj;
	}
	
	@Override
	public void run() {
		obj.taskTest();
	}
	
}

class Base {
	
	synchronized public void taskTest(){
		for(int i=0;i<100;i++)
			System.out.println(Thread.currentThread().getName()+"$");
	}
	
}

class Derive extends Base{
	String s;
	Derive(String s){
		this.s =s;
	}
	
	@Override
	public void taskTest(){
		for(int i=0;i<100;i++)
			System.out.println(Thread.currentThread().getName()+s);
	}
}
