package com.oop;

/**
 * instance variable will not be overridden in any case. instance variable will
 * always be accessed of its object type.
 * @author vachopra
 *
 */
public class InstanceVariableOverriding {
	public static void main(String[] args) {
		InstanceVariableOverridingBase obj = new InstanceVariableOverridingDrived();
		obj.printName(); // will print base
		System.out.println(obj.name);
	}
}

class InstanceVariableOverridingBase{
	String name = "Base";
	public void printName(){
		System.out.println(name);
	}	
}

class InstanceVariableOverridingDrived extends InstanceVariableOverridingBase{
	String name = "Drived";
	public void printAgain(){
		System.out.println(name);
	}
	public void printName(){
		System.out.println(name);
	}
}
