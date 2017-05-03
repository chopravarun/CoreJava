package com.oop;

import java.lang.reflect.ReflectPermission;
import java.security.Permission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class ImmutableObject {
	private final int number;
	private final ImmutableClone objectClone;
	/*
	 * Prevents reflection
	 */
	{
		SecurityManager securityManager = new SecurityManager(){
			@Override
			public void checkPermission(Permission perm){
				if(perm instanceof ReflectPermission){
					Map<Thread,StackTraceElement[]> map = Thread.getAllStackTraces();
					List<StackTraceElement> list = new ArrayList<StackTraceElement>(); 
					for(Entry<Thread, StackTraceElement[]> entry : map.entrySet()){
						list.addAll(Arrays.asList(entry.getValue()));
					}
					for(StackTraceElement ele : list){	
						System.out.println(ele.getClassName());
						if(ImmutableObject.class.getName().equals(ele.getClassName())){
							throw new SecurityException();
						}
					}
				}
			}
		};
		
		System.setSecurityManager(securityManager);
	}	
	public ImmutableObject(int number,ImmutableClone objectClone) {
		this.number = number;
		this.objectClone = objectClone;
	}
	public int getNumber() {
		return number;
	}
	public ImmutableClone getObjectClone() {
		try{
			return (ImmutableClone)objectClone.clone();
		}catch(CloneNotSupportedException e){
			System.out.println(e);
			return null;
		}
	}
	@Override
	public String toString() {
		return "ImmutableObject [number=" + number + ", objectClone="
				+ objectClone + "]";
	}	
	
}
class ImmutableClone implements Cloneable{
	int id;
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}

	@Override
	public String toString() {
		return "ImmutableClone [id=" + id + "]";
	}
	
}
