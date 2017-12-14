package com.generics;

import java.util.ArrayList;
import java.util.List;

public class Generics2 {
	/**
	 * It will accept all sutypes of animals list, but you cannot add anything in collection
	 * 
	 * @param animals
	 */
	public void genr(List<? extends Animal> animals){
		//animals.add(new Dog());
	}
	
	/**
	 * It will accept all super types of dog, but you can add only Dog or subTypes of Dog 
	 * @param args
	 */
	public void baseClass(List<? super Dog> animals){				
		animals.add(new GolderRetriver());
		Animal a = new Cat();
		// can not add animal type
		//animals.add(a);			
	}
	
	/**
	 * you can pass anything into this method, this is as good as <? extends Object>, 
	 * but <object> is not as good as <? extends object> or <? super Object>.
	 * @param anything
	 */
	public void questionMark(List<?> anything){
		anything.add(new Dog());
	}
	
	public void methodCall(){
		List<Animal> animals =new ArrayList<Animal>();
		baseClass(animals);		
		List<GolderRetriver> gold = new ArrayList<>();
		// can not add subtypes of dog, only super types of dog is allowed 
		//baseClass(gold);
	}
	
	public static void main(String[] args) {
		
	}
}

