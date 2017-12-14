package com.oop;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/*
 * Rules for over ridding : 
 * 0. Methods which are visible can be overridden
 * 1. Can not narrow access modifier
 * 2. Can return co-varient return type  
 * 3. Method parameter should be exactly same
 * 4. Can not throw exception broader than base class 
 * ex : base exp - FileNotFoundException , Drived exp - IOException
 * 5. final and static methods can not be over ridden
 * 6. synchronized method can be over ridden by a non-synchronized method. this behavior does not go down 
 * in derived class
 */
class BaseClass{
	
	public List<String> method(List<String> in) throws IOException{//FileNotFoundException{
		System.out.println("this may throw IO exception ");
		return null;
	}
	
	public int overLoading(int n){
		System.out.println(n);
		return n;
	}
	
	public float overLoading(int n,int m){
		System.out.println(m);
		return m;
	}
}

 class test extends BaseClass{
	@Override
	public ArrayList<String> method(List<String> fis) throws IOException{
		System.out.println("derived");
		return null;
	}
}

 public class MethodOverRidding {

	 
	 public void testFun(Object str){
	  System.out.println("test " +str);
	 }
	 
	 public void testFun(Integer in){
	  System.out.println("test " +in);
	 }
	 
	 
	 
	 
	 public static void main(String[] args) throws IOException {
	    
	  
		 BaseClass b = new test();
		 test b2 =new test();
		 
		 //b.method(null);
		 b2.method(null);
	  
		 
	 }
	 
	}
