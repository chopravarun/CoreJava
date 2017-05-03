package com.algo.string;

public  class MergeStringAlternatePlaces {
	public String mergeAlternative(String str1,String str2){
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		
		int length = (arr1.length >= arr2.length)? arr1.length:arr2.length;
		StringBuilder merged = new StringBuilder();
		for(int i=0;i<length ;i++){
			
			if(arr1.length <= i ){
				merged.append(arr2[i]);
				continue;
			}
			if(arr2.length <= i){
				merged.append(arr1[i]);
				continue;
			}
			
			merged.append(arr1[i]);
			merged.append(arr2[i]);
		}
		
		char[] test = null;
		StringBuilder b =new StringBuilder(new String(test));
		
		
		return merged.toString();
	}
	public static void main(String[] args) {
		MergeStringAlternatePlaces obj =new MergeStringAlternatePlaces();
		String ss = obj.mergeAlternative("abcghij", "def");
		System.out.println(ss);
		
	}
	
}
