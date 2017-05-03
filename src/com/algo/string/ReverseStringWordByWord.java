package com.algo.string;

import java.util.Arrays;
import java.util.Date;

public class ReverseStringWordByWord {
	public static void main(String[] args) {
		String str = "i am your man";
		char[] charArr = str.toCharArray();
		int lastspace = charArr.length;
		StringBuilder strb = new StringBuilder();
		for(int i=charArr.length-1;i>=0;i--){
			if(charArr[i] == ' '){
				strb.append(Arrays.copyOfRange(charArr, i+1, lastspace));
				strb.append(' ');
				lastspace = i;
			}
		}
		strb.append(Arrays.copyOfRange(charArr, 0, lastspace));
		System.out.println(strb.toString());		
	}
}
