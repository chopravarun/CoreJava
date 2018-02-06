package com.hackerrank;

public class FibonacciMemoization {
	static long memo[] = new long[50];
	
	public static long calculateMemoized(int n){		
		if(n==0){
			return 0;		
		}else if(n==1){
			return 1;
		}else if(memo[(int)n]!=0){
			return memo[n];
		}else{
			long l = calculateMemoized(n-1)+calculateMemoized(n-2);
			memo[n] = l;
			return l;
		}		
	}
	public static long calculate(int n){
		if(n==0){
			return 0;			
		}else if(n==1){
			return 1;
		}else{
			return calculate(n-1)+calculate(n-2);
		}
	}
	
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(FibonacciMemoization.calculate(45));
		System.out.println(System.currentTimeMillis()-start);
		
		start = System.currentTimeMillis();
		System.out.println(FibonacciMemoization.calculateMemoized(45));
		System.out.println(System.currentTimeMillis()-start);
	}
}
