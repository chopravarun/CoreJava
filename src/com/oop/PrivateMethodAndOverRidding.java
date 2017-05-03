package com.oop;

public class PrivateMethodAndOverRidding {
	public static void main(String[] args) {
		BaseClassPrivateMethod base = new DrivedClass();
		//base.fun(10); // cannot call private 
	}
}
class BaseClassPrivateMethod{
	private void fun(int n){
		System.out.println("base class");
	}
}
class DrivedClass extends BaseClassPrivateMethod{
	public void fun(int n){
		System.out.println("drived class");
	}
}
