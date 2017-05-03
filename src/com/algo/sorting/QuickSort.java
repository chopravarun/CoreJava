package com.algo.sorting;
/**
 * Quick sort takes one pivot element at end and insert it into a point where left
 * of pivot is less and right of pivot is greater than pivot.
 * and split left and right array and go operation again.
 * @author vachopra
 *
 */
public class QuickSort {
	/**
	 * start i=-1,j=0,pivot: last element in current half. compare j'th element to
	 * pivot if(j'th < pivot) increment i. and swap i'th element and j'th element.
	 * once it reached end. swap i+1 index with pivot. after this left of pivot 
	 * will be less than pivot and right is greater than it. 
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
	public int getPivotIndex(int[] arr,int low,int high){
		int pivot = arr[high];
		int i=-1;		
		for(int j=0;j<high;j++){
			if(arr[j] <= pivot){
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;				
			}			
		}
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		return i+1;
	}
	public void split(int[] arr,int low,int high){
		int pivot = -1;
		if(low < high){
			pivot = getPivotIndex(arr,low,high);
			split(arr, low, pivot-1);
			split(arr,pivot+1,high);
		}
	}
	
	
	public static void main(String[] args) {
		int[] n = {9,8,7,6,5,4,3,2,1};
		QuickSort sort = new QuickSort();
		sort.split(n,0,n.length-1);
		System.out.println(n);
	}
}
