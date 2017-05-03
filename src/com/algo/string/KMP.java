package com.algo.string;

public class KMP {
	char[] searchPattern;
	int[] tempArr;
		
	
	public int search(String searchString){
		searchPattern = searchString.toCharArray();
		return 0;
	}
	
	public void build(){
		int j=0,i=j+1;
		tempArr = new int[searchPattern.length];
		tempArr[0] = 0;
		while(i<searchPattern.length){
			if(searchPattern[j]==searchPattern[i]){
				tempArr[i] = j+1;
				i++;j++;
			}else{
				if(j!=0){
					j = tempArr[j-1];
				}else{
					j=0;
					i++;
				}
			}
		}
		System.out.println(tempArr);
	}	
	
	public static void main(String[] args) {
		KMP obj = new KMP();
		obj.search("abcdabca");
		//obj.computeTemporaryArray("abcdabca".toCharArray());
		obj.build();
	}
}
