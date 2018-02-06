package com.algo.string;

public class SearchStringIndex {
	public static void main(String[] args) {
		char[] gg = "hi".toCharArray();
		
		
		if("hi".equals(gg)){
			System.out.println("test");
		}
		if(isExist(443331233,123)){
			System.out.println("esist");
		}
	}
	
	public static boolean isExist(int bigNumber,int searchNumber){
		int[] hashPattern = {0,0,0,0,0,0,0,0,0,0};
		while(bigNumber > 0){
			int tmp = bigNumber%10;
			hashPattern[tmp]++;
			bigNumber = bigNumber/10;
		}
		
		while(searchNumber>0){
			int tmp = searchNumber%10;
			if(hashPattern[tmp] == 0 ){
				return false;
			}
			searchNumber = searchNumber/10;
		}
		return true;
	}
}
