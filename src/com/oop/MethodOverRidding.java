package com.oop;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

class BaseClass{
	public List<String> method(List<String> in) throws Exception{
		System.out.println("this may throw IO exception ");
		return null;
	}
}

 class test extends BaseClass{
	@Override
	public ArrayList<String> method(List<String> fis){
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
	 
	 
	 
	 
	 public static void main(String[] args) {
	    
	  
		 BaseClass b = new test();
		 test b2 =new test();
		 
		 //b.method(null);
		 b2.method(null);
	  
		 
	 }
	 
	}
