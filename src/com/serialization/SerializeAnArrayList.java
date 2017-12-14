package com.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializeAnArrayList {
	private static void writeObject(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("test");
		list.add("ss");
		list.add(null);
		list.add("dd");
		list.add(null);
		list.add("ff");
		list.add(null);
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ArrayList.ser"));
			oos.writeObject(list);
		}catch(Exception e){
			System.out.println(e);
		}		
	}
	
	private static void readObject(){
		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ArrayList.ser"));
			ArrayList<String> list = (ArrayList<String>) ois.readObject();
			System.out.println(list);
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		writeObject();
		
		readObject();
	}
}
