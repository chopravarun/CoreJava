package com.generics;

public class Generics {
	public void pass(Animal[] a){
		a[0] = new Cat();
	}
	public static void main(String[] args) {
		Dog[] d = new Dog[3];
		Generics obj = new Generics();
		obj.pass(d);
	}
}

interface Animal{}
class Dog implements Animal{}
class Cat implements Animal{}
class GolderRetriver extends Dog{}
