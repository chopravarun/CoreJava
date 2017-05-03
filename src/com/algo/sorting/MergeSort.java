package com.algo.sorting;

import java.util.Arrays;

public class MergeSort {
	public int[] split(int[] arr){
		if(arr.length == 1){
			return arr;
		}else{
			int mid = arr.length/2;
			int[] left = split(Arrays.copyOfRange(arr, 0, mid)); 
			int[] right = split(Arrays.copyOfRange(arr, mid,arr.length));					
			return merge(left,right);
		}		
	}
	public int[] merge(int[] left,int[] right){		
		int[] merged = new int[left.length+right.length];
		int leftIndex=0;
		int rightIndex=0;
		int mergeIndex = 0;
		while(mergeIndex < merged.length){
			if(rightIndex == right.length){
				while(leftIndex!=left.length){
					merged[mergeIndex] = left[leftIndex];
					mergeIndex++;
					leftIndex++;
				}
				break;
			}
			if(leftIndex == left.length){
				while(rightIndex!=right.length){
					merged[mergeIndex] = right[rightIndex];
					mergeIndex++;
					rightIndex++;
				}
				break;
			}
			
			if(left[leftIndex]< right[rightIndex]){
				merged[mergeIndex] = left[leftIndex];
				leftIndex++;
				mergeIndex++;
			}else{
				merged[mergeIndex] = right[rightIndex];
				rightIndex++;
				mergeIndex++;
			}
		}
		return merged;
	}
	public static void main(String[] args) {
		MergeSort m = new MergeSort();
		int[] n = {18,4,23,66,28,90,33};
		int nn[] = m.split(n);
		System.out.println(nn);
	}
}
