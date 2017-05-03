package com.algo.string;

public class ReverseUsingRecursion {
	public String reverse(char[] str,int length,int n){
		if(n==length){
			return "";
		}else{
			return reverse(str, length, n+1)+str[n];
		}
	}
	
	public static void main(String arg[]){
		ReverseUsingRecursion obj = new ReverseUsingRecursion();
		String str = "";
		String strr = obj.reverse(str.toCharArray(), str.length(), 0);
		System.out.println(strr);
	}
	
}
