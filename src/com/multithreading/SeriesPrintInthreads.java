package com.multithreading;


public class SeriesPrintInthreads {
	public static void main(String[] args) {
		Printer p = new Printer();
		Thread t1 = new Thread(new PrintThread(true, p));
		Thread t2 = new Thread(new PrintThread(false, p));
		t1.start();
		t2.start();
		while(true){
			StackTraceElement[] ele = t2.getStackTrace();
			for(StackTraceElement e : ele){
				System.out.println(e);
			}
			t2.getStackTrace();
		}
	}
}
class PrintThread implements Runnable{
	boolean isEven;
	Printer p ;
	
	public PrintThread(boolean isEven,Printer p) {
		this.isEven = isEven;
		this.p = p;		
	}
	

	@Override
	public void run() {
		while(true && p.n < 15){
			try{
				if(isEven){
					p.printEven();
				}else{
					p.printOdd();
				}
			}catch(Exception e){
				System.out.println(e);
			}
		}
	}
	
	
}

class Printer{
	Integer n = 1;
	synchronized public void printOdd() throws InterruptedException{
		while(n%2==0){
			this.wait();			
		}
		System.out.println("Odd : "+n);
		n++;
		this.notifyAll();
		
	}
	
	synchronized public void printEven() throws InterruptedException{
		while(n%2!=0){
			this.wait();			
		}
		System.out.println("Even : "+n);
		n++;
		this.notifyAll();
	}
	
}




