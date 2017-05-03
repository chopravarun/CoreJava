package com.oop;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ImmutableObjectMain {
	public static void main(String[] args) {
		System.out.println(ImmutableObjectMain.test());
		
		ImmutableClone clone = new ImmutableClone();
		ImmutableObject obj =new ImmutableObject(10, clone);
		
		
		try {
			ImmutableObject o = ImmutableObject.class.getConstructor(int.class,ImmutableClone.class).newInstance(10,clone);
			Field[] fields = o.getClass().getDeclaredFields();
			for(Field f :fields){
				if(!f.isAccessible()){
					f.setAccessible(true);
				}
				f.set(o, 20);
				break;
			}	
			System.out.println(o);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public static int test(){
		try{
			return 1;
		}catch(Exception e){
			return 2;
		}finally{
			return 3;
		}
	}
}
