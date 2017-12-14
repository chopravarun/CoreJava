package com.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialization2 {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean isWrite = false;
		ClassB objB = new ClassB();
		ClassA objA = new ClassA(20);
		objB.obj = 20;
		objB.b = 10;
		
		if(isWrite){
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("seralization2.ser"));
			oos.writeObject(objB);
			oos.close();
		}else{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("seralization2.ser"));
			objB = (ClassB)ois.readObject();
			System.out.println(objB);
		}
	}
}

class ClassA{
	int a;
	public ClassA(int a) {		
		this.a = a;
		System.out.println("constructor class A");
	}
	@Override
	public String toString() {
		return "ClassA [a=" + a + "]";
	}
	
}
class ClassB implements Serializable{
	private static final long serialVersionUID = -6389368295231393232L;	
	
	
	transient Integer obj;
	int b;
	
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.writeInt(obj);		
		out.defaultWriteObject();
	}
	
	private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException {
		this.obj = (int)in.readObject();		
		in.defaultReadObject();
	}

	@Override
	public String toString() {
		return "ClassB [obj=" + obj + ", b=" + b + "]";
	}
	
	
}