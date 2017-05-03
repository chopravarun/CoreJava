package com.serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeInnerClass implements Serializable{
	
	private static final long serialVersionUID = -1230027704282127674L;
	
	int number;
	MyInnerClass inner;
	
	class MyInnerClass implements Serializable{
		int number = SerializeInnerClass.this.number+10;
		
		public int getNumber(){
			return this.number;
		}		
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		SerializeInnerClass clas = new SerializeInnerClass();
		clas.inner = clas.new MyInnerClass();
		
		boolean isWrite = true;
		if(isWrite){
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SerializedInner.ser"));
			oos.writeObject(clas);
			oos.close();
		}				
	}
}
