package com.generics;

public class CustomGenericClass {
	public static void main(String[] args) {
		Rental<Dog> genricCustom = new Rental();
		Dog d = genricCustom.getData();			
	}
}
/**
 * Generic Class defination
 * @author choprava
 *
 * @param <T>
 */
class Rental<T>{
	T data;	
	public T getData(){
		return data;
	}
}
/**
 * this is also a valid generic  method declaration
 * @author choprava
 *
 */
class X{
	public <X> void x(X x){
		System.out.println(x);
	}
	
}

/**
 * generic method 
 * @author choprava
 *
 */
class GenericMethod{
	/**
	 * Template declaration with <T> is important, other wise type will not resolved.
	 * @param t
	 */
	public <T> T getGenericData(T t){
		return t;
	}
}
