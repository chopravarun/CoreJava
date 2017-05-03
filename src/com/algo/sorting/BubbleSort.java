package com.algo.sorting;
/**
 * basic idea put greatest element to last. then do not compare it further.
 * This comparison is made pair by pair which are being compare would be 1,2 then 2,3 
 * 3,4 and so on.. this make sure last element would be greatest/lowest. so we can 
 * skip going till last item 
 * 
 * complexity : O(n^2)
 * @author vachopra
 *
 */
public class BubbleSort {
	public int[] bubbleSort(int n[]){
		for(int i=0;i<n.length-1;i++){
			for(int j=0;j<(n.length-1)-i;j++){ // skip last element after 
				if(n[j] > n[j+1]){
					int temp = n[j];
					n[j] = n[j+1];
					n[j+1] = temp;
				}
			}
		}
		return n;		
	}
	public static void main(String[] args) {
		BubbleSort sort = new BubbleSort();
		int[] n = {12,33,12,45,6,2,4,67};
		 n = sort.bubbleSort(n);
		
	}
}
