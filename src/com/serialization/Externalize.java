package com.serialization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Externalize {
	public void readStudent(){
		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("StudentExternal.ser"));
			StudentExternal student  = (StudentExternal)ois.readObject();
			System.out.println(student);		
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void writeStudent(StudentExternal stuExt){
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("StudentExternal.ser"));
			oos.writeObject(stuExt);
			oos.flush();
			oos.close();
			System.out.println("ObjectWritten");
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		boolean isWrite = false;
		Externalize obj = new Externalize();
		StudentExternal ee = null;		
		if(isWrite){
			ee = new StudentExternal();
			ee.fname= "varun";
			ee.lname = "chopra";
			ee.age = 10;
			obj.writeStudent(ee);
		}else{
			obj.readStudent();
		}
	}
}

class StudentExternal extends Human implements Externalizable{
	public static final long serialVersionUID = -12333;
	
	String fname;
	String lname;
	int age;
	
	public  StudentExternal() {
		// TODO Auto-generated constructor 
		ssn = "new ssn";
	}
	@Override
	public String toString() {
		return "StudentExternal [fname=" + fname + ", lname=" + lname
				+ ", age=" + age +"- ssn :"+super.ssn+"]";
	}
	@Override
	public void readExternal(ObjectInput o) throws IOException,
			ClassNotFoundException {
		System.out.println("reading external");
		fname =  (String)o.readObject();
		lname = (String)o.readObject();
		age = o.readInt();
		ssn = (String) o.readObject();
		
	}
	@Override
	public void writeExternal(ObjectOutput o) throws IOException {
		System.out.println("writing external");
		o.writeObject(fname);
		o.writeObject(lname);
		o.writeInt(age);
		o.writeObject(ssn);
	}
	
}
