package com.ds.linkedlist;

public class ReverseLinklist extends SwapElementsLikedList{

	public Node reverseList(Node head){
		Node newStart = null;
		if(head.next == null){			
			return head;
		}else{
			Node temp = reverseList(head.next);
			newStart = temp;
			while(temp.next!=null){
				temp = temp.next;
			}
			temp.next = head;
			head.next = null;						
			return newStart;
			
		}			
	}
	
	
	
	public static void main(String arg[]){
		ReverseLinklist rev = new ReverseLinklist();
		rev.createList();
		rev.traverse();
		Node head = rev.start;
		rev.start = rev.reverseList(head);
		
		System.out.println();
		rev.traverse();
	}
}
