package exp;

import java.io.File;



public class TestClass {
	public static void main(String[] args) {
		int number  = (int)(Math.random()*100);
		number = getNull();
		System.out.println(number);
		
	}
	public static Integer getNull(){
		return null;
	}
}
