package com.ds.linkedlist;

public class PrintReverseList extends NodeCreateAndTraverse{
	public Node printReverse(Node head){
		Node prev = null;
		Node curr = head;
		Node next = null;
		while(curr.next!=null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;			
		}
		return prev;
		
	}
	public static void main(String[] args) {
		int[] data = {1,2,3,4,5,6};
		PrintReverseList obj = new PrintReverseList();
		Node head = obj.createList(data);
		obj.traverse(head);
		head= obj.printReverse(head);
		System.out.println();
		obj.traverse(head);
		
	}
}
