package com.serialization;

public class Teee {
	public static void main(String[] args) {
		a obj = new b();
		obj.test();
	}
}


class a{
	public Object test(){
		System.out.println("a human");
		return null;
	}
}

class b extends a{
	public Integer test(){
		System.out.println("b student");
		return null;
	}
}

