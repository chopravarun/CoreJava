package com.oop;
/**
 * Sequence of execution :
 * 1. if class is loaded then static block will be executed first 
 * 2. if object of class is created then values will be assigned 
 * 	  to instance variables
 * 3. after then instance block will be created.
 *  
 * @author vachopra
 *
 */
public class SequenceOfExecution {
	int code = 10;
	static{
		System.out.println("static block");
	}
	{
		System.out.println("instance block : "+code);
	}
	
	public static void main(String[] args) {
		SequenceOfExecution seq = new SequenceOfExecution();		
	}
	
}
