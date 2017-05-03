package com.algo.sorting;
/**
 * start from 1 index compare it with element at left and intsert it on required position.
 * by the time you complete array all element to left will be sorted.
 * 
 *  complexity : O(n^2)
 * @author vachopra
 *
 */
public class InsertionSort {	
	public int[] insertionSort(int n[]){
		int v,j;
		for(int i=1;i<n.length; i++){
			v= n[i];
			j = i;
			while(j>=1 && n[j-1]>v ){
				n[j] = n[j-1];
				j--;
			}
			n[j] = v;
		}
		
		return n;
	}
	
	public static void main(String[] args) {
		InsertionSort sort  =new InsertionSort();
		int[] n = {18,4,23,66,28,90,33};
		n = sort.insertionSort(n);
	}
}
