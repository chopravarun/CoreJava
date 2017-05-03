package com.hackerrank;

import java.util.Scanner;

public class LeftRotationArray {
	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		int length  = in.nextInt();
		int operations  = in.nextInt();
		int[][] command = new int[operations][3];
		for(int i=0;i<operations;i++){
			for(int j=0;j<3;j++){
				command[i][j] = (j==2)?in.nextInt():in.nextInt()-1;
			}
		}
		
		int[] arr = new int[length];
		for(int i=0;i<length;i++){
			arr[i] = 0;
		}
		
		Integer sum = null;
		
		for(int i=0;i<operations;i++){
			for(int j=command[i][0];j<=command[i][1];j++){
				arr[j] = arr[j] + command[i][2];				
			}
			System.out.println(i);
		}
		
		System.out.println(sum);
		
	}	
	public void leftRotation(){
		Scanner in  = new Scanner(System.in);
		int arrCount  = in.nextInt();
		int rotation  = in.nextInt();
		int[] arr = new int[arrCount];
		for(int i=0; i<arrCount ; i++){
			arr[i]=in.nextInt();
		}
		for(int i=0;i<rotation;i++){
			int temp = arr[0];
			for(int j=0;j<arr.length-1;j++){
				arr[j] = arr[j+1];
			}
			arr[arr.length-1] = temp;
		}
		for(int i=0;i<arrCount;i++){
			System.out.print(arr[i]+" ");
		}
	}
	
	public void sparseArray(){
		Scanner in  = new Scanner(System.in);
		int linesCount = in.nextInt();
		String[] lines = new String[linesCount];
		for(int i=0;i<linesCount;i++){
			lines[i] = in.next();
		}
		int queryCount = in.nextInt();
		String[] query = new String[queryCount];
		for(int i=0;i<queryCount;i++){
			query[i] = in.next();
		}
		for(String q : query){
			int count = 0;
			for(String l : lines){
				if(q.equals(l)){
					count++;
				}
			}
			System.out.println(count);
		}
		
	}		
	
}
