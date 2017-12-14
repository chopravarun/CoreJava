package exp;

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
		for (Map.Entry <Thread, StackTraceElement []> entry: 
            Thread.getAllStackTraces().entrySet ())
        {
            System.out.println (entry.getKey ().getName () + ":");
            for (StackTraceElement element: entry.getValue ())
                System.out.println ("\t" + element);
        }	
	}
	
}
