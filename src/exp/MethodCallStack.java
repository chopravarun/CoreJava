package exp;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class MethodCallStack {
	public static void main(String[] args) {
		MethodCallStack obj = new MethodCallStack();
		obj.one();
	}	
	public void one(){
		two();
	}
	public void two(){
		three();
	}
	public void three(){
		four();
	}
	public void four(){
		getStack();
	}
	
	public void getStack(){
		StackTraceElement[] traces = Thread.currentThread().getStackTrace();
		for(StackTraceElement trace : traces){
			System.out.println(trace);
		}
	}
	
}
