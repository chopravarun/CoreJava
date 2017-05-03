package com.oop;

public class Clonning {
	public static void main(String[] args) throws CloneNotSupportedException {
		AddressForClonning address = new AddressForClonning();
		address.address1 = "address1";
		address.address2 = "address2";
		
		EmployeeForClonning emp = new EmployeeForClonning("student", 10, address);
		EmployeeForClonning emp2 = (EmployeeForClonning) emp.clone();
		System.out.println(emp.hashCode()+" - "+emp.address.hashCode());
		System.out.println(emp2.hashCode()+" - "+emp2.address.hashCode());
		
	}
}
class EmployeeForClonning implements Cloneable{
	String name;
	int id;
	AddressForClonning address;
	
	public EmployeeForClonning(String name,int id,AddressForClonning address) {
		this.name = name;
		this.id = id;
		this.address = address;
	}

	@Override
	public String toString() {
		return "EmployeeForClonning [name=" + name + ", id=" + id
				+ ", address=" + address + "]";
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		return new EmployeeForClonning(name, id, (AddressForClonning)this.address.clone());
	}
	
	
}
class AddressForClonning implements Cloneable{
	String address1;
	String address2;
	@Override
	public String toString() {
		return "AddressForClonning [address1=" + address1 + ", address2="
				+ address2 + "]";
	}
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
}