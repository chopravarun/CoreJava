package com.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MatrixHourglass {
	public static void main(String[] args) {
		String str = "beabeefeab";
		  
		  Map<Character,Integer> map = new HashMap<Character,Integer>();
		  
		  
		   for(int i=0;i<str.length();i++){
		   
		    map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
		   
		   }
		  
		   System.out.println(map);
		   
		   char arr[] = new char[map.size()];
		   
		   int i=0;
		   for(Character m : map.keySet()){
		    
		    arr[i]=m;
		    i++;
		   }
		   
		   int countArry [] = new int[10];
		 
		   int count =0;
		   
		   for(int k=0;k<arr.length;k++){
		    for(int j=k+1;j<arr.length;j++){
		     
		     String finalStr = removeString(str,arr[k],arr[j]);
		     
		     if(isPattern(finalStr)==true){
		     
		     countArry[count] = finalStr.length();
		     count++;
		     }
		     
		    }
		   }
		   Arrays.sort(countArry);
		  // for(int m=0;m<countArry.length;m++)
		   System.out.println(countArry[9]);

	}

	 public static String removeString(String str, char c, char d) {
	 
	  StringBuilder strbuilder = new StringBuilder(str);
	  
	  for(int i=0; i<strbuilder.length();i++){
	   if(strbuilder.charAt(i)!=c && strbuilder.charAt(i)!=d){
	    
	    strbuilder.delete(i, i+1);
	    i=i-1;
	   }
	   
	  }
	  
	  String res = new String(strbuilder);
	  
	  return res;
	 }

	 
	 public static boolean isPattern(String s)
	 {
	  for(int i = 0;i<s.length()-2;i++)
	  {
	   if(s.charAt(i)!=s.charAt(i+2))
	    return false;
	  }
	  return true;
	 }
}

