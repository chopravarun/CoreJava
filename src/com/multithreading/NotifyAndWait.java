package com.multithreading;


public class NotifyAndWait {
	public static void main(String[] args) {
		Machine m = new Machine();
		Operator o = new Operator(m);
		o.start();
		m.start();
	}
}

class Operator extends Thread{
	
	Machine machine;
	Operator(Machine m){
		this.machine = m;
	}
	public Instruction getInstruction(){
		Instruction i =new Instruction();
		i.str = "execute";
		return i;
	}
	public void run(){
		while(true){
			Instruction i = getInstruction();
			System.out.println("sending instruction");
			machine.addInstruction(i);
		}			
	}
}
class Machine extends Thread{
	
	Instruction i = new Instruction();
	public void addInstruction(Instruction i){
		synchronized (i) {
			this.i = i;
			System.out.println("instruction recived ");
			i.notify();
		}
	}
	
	public void run(){
		synchronized (i) {
			while(true){
				try {
					System.out.println("instruction processed");
					i.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

class Instruction{
	public String str;
}