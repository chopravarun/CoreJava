package com.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class Serialization {
	public void readObject(){
		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Student.ser"));
			Student s = (Student)ois.readObject();
			System.out.println(s);
		}catch(Exception e){
			System.out.println("reading "+e);
		}
	}
	
	public void writeObejct(Student s){
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Student.ser"));
			oos.writeObject(s);
			oos.close();
			
		}catch(Exception e){
			System.out.println("write "+e);
		}
	}
	
	public static void main(String arg[]){
		/*Student s = new Student();
		s.fname= ("varun");
		s.lname =("chopra");*/
		Serialization ser = new Serialization();
		//ser.writeObejct(s);
		ser.readObject();
		
	}
}

class Human {
	String ssn;
	Human(){
		System.out.println("humane");
	}
	
}

class Student extends Human implements Serializable {
	String fname;
	String lname;
	public Student(){
		super.ssn = "hello";
		System.out.println("student default");			
	}
	@Override
	public String toString() {
		return "Student [fname=" + fname + ", lname=" + lname +" ssn : "+super.ssn+ "]";
	}	
	
	
	
}
