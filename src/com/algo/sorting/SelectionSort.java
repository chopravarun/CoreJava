package com.algo.sorting;
/**
 * just like bubble sort it put smallest element at first and skip first element in 
 * next iteration and so on.
 * but difference is it doesnot swap entire list pairs
 * less number of swaps.
 * 
 * complexity : O(n^2)
 * @author vachopra
 *
 */
public class SelectionSort {
	public int[] selectionSort(int[] n){
		for(int i=0;i<n.length-1;i++){
			int min = i;
			for(int j=i;j<n.length;j++){				
				if(n[j]<n[min]){
					min = j;
				}
			}
			int temp = n[min];
			n[min] = n[i];
			n[i] = temp;
		}
		return n;
	}
	
	public static void main(String[] args) {
		SelectionSort sort = new SelectionSort();
		int[] n = {18,4,23,66,28,90,33};
		n = sort.selectionSort(n);		
	}
}
