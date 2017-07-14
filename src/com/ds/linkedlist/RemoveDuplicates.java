package com.ds.linkedlist;

public class RemoveDuplicates extends NodeCreateAndTraverse {
	
	public void removeDuplicatesSorted(Node start){
		Node temp =start;
		while(temp!=null){
			Node tempNext = temp.next;
			while(tempNext!=null && temp.data == tempNext.data){
				tempNext = tempNext.next;
			}
			
			temp.next = tempNext;
			temp = temp.next;
			System.out.println(start);
		}
		
	}
	
	public static void main(String arg[]){
		RemoveDuplicates ob = new RemoveDuplicates();
		int[] i = new int[]{1,2,2,2,2,3,3,3,3,3,4,4,4,4,4,4,4,5,5,5,5,5,5,6,6,6,6,6,6,6,6,6,6,6,6,6};
		Node start = ob.createList(i);
		ob.removeDuplicatesSorted(start);
		
	}
}
