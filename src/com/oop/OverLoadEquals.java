package com.oop;

public class OverLoadEquals {

}
class Employee{
	@Override
	public boolean equals(Object o){
		if(o!=null && o.getClass().equals(this.getClass())){
			Employee e = (Employee)o;	
		}
		return false;
	}
}
