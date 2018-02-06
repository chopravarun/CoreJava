package exp;

public class ThreadExpp extends Thread{
	public ThreadExpp(Runnable r){		
		super(r);
	}
	
	public void run(){		
		System.out.println("outer");
		super.run();
	}
	public static void main(String[] args) {
		ThreadExpp obj = new ThreadExpp(new Runn());
		obj.start();
	}
}

class Runn implements Runnable{

	@Override
	public void run() {
		System.out.println("inner");
		
	}
	
}
