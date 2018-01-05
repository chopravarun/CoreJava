package exp;

public class TestClass {
	
	public static void main(String[] args) {
		System.out.println(T.i);
	}		
}
class T { 
	
	public final static int i=100;
	static{
		System.out.println("yest");
	}
}
