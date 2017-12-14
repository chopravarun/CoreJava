package com.oop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Iterator {
	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		l.add("1");
		l.add("1");
		l.add("1");
		l.add("2");
		l.add("1");
		
		java.util.Iterator<String> itr = l.iterator();
		
		System.out.println(itr.getClass());
		
		while(itr.hasNext()){
			String cc = itr.next();
			if(cc.equals("2")){
				l.remove(cc);
			}
		}
		
		//System.out.println(l);
		badal();
		
	}
	
	public static void badal(){
		List<String> l1 = new ArrayList<String>();
		List<String> l2 = new ArrayList();
		List<String> l3 = new ArrayList();
		
		l1.add("123");
		l1.add("456");
		l1.add("768");
		
		l2.add("888");l2.add("777");l2.add("123");l2.add("897");l2.add("234");
		l3.add("666");l3.add("123");l3.add("098");l3.add("777");l3.add("321");
		
		Set<String> ss = new HashSet<String>();
		
		ss.addAll(l1.subList(l1.indexOf("123"), l1.size()));
		ss.addAll(l2.subList(l2.indexOf("123"), l2.size()));
		ss.addAll(l3.subList(l3.indexOf("123"), l3.size()));
		System.out.println(ss);
		
	}
}
