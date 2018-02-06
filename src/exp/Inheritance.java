package exp;

public class Inheritance {
	public static void main(String[] args) {
		Parent p = new Child();
		p.parent();
	}
}

class Parent { 
	public static void parent(){
		System.out.println("parent");
	}
}

class Child extends Parent{
	public static void parent(){
		System.out.println("child");
	}
}
